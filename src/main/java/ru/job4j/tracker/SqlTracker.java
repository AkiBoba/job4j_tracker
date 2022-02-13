package ru.job4j.tracker;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public void init() {
        try (InputStream in = SqlTracker
                .class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement(
                "insert into items(name, created) values (?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean result;
        try (PreparedStatement pst = cn.prepareStatement(
             "update items set name =?, created = ? where id = ?;")) {
             pst.setInt(3, id);
             pst.setString(1, item.getName());
             pst.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
             result = pst.executeUpdate() > 0;
            }
        return result;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean result;
        try (PreparedStatement ps = cn.prepareStatement(
                "delete from items where id = ?;")) {
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (var statement = cn.createStatement()) {
            var selection = statement.executeQuery(
                    "select * from items;"
            );
            while (selection.next()) {
                list.add(new  Item(selection.getInt(1),
                    selection.getString(2),
                    getLocalDateTime(selection
                        .getTimestamp(3)
                        )
                    )
                );
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "select * from items where name = ?;")) {
            ps.setString(1, key);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                list.add(newItem(res)
                );
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement(
             "select * from items where id = ?;")) {
             ps.setInt(1, id);
             ResultSet res = ps.executeQuery();
             if (res.next()) {
                 item = newItem(res);
             }
        }
        return item;
    }

    private Item newItem(ResultSet res) throws SQLException {
        return new Item(res.getInt(1),
            res.getString(2),
            getLocalDateTime(res
            .getTimestamp(3)
            )
        );
    }

    private LocalDateTime getLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}