package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
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
                "insert into items(name, created) values (?, ?)")) {
            ps.setString(1, item.getName());
            ps.setString(2, Timestamp.valueOf(item.getCreated()).toString());
            ps.execute();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean result = true;
        try (var statement = cn.createStatement()) {
            var selection = statement.executeQuery(String.format(
                            "select id from items where id = ?", id
                    )
            );
            if (!selection.next()) {
                result = false;
            }
            statement.executeQuery(String.format(
                            "update items set name = ?, created = ? where id = ?",
                            item.getName(),
                            Timestamp.valueOf(item.getCreated()).toString(),
                            item.getId()
                    )
            );
        }
        return result;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean result = false;
        try (PreparedStatement ps = cn.prepareStatement(
                "delete users items where id = ?")) {
            ps.setInt(1, id);
            ps.execute();
            result = ps.executeUpdate() > 0;
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (var statement = cn.createStatement()) {
            var selection = statement.executeQuery(
                    "select * from items"
            );
            while (selection.next()) {
                list.add(new  Item(selection.getInt(1),
                                selection.getString(2),
                                getLocalDateTime(selection
                                        .getTimestamp(3))
                        )
                );
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> list = new ArrayList<>();
        try (var statement = cn.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from items where name = ?", key
                    )
            );
            while (selection.next()) {
                list.add(new  Item(selection.getInt(1),
                                selection.getString(2),
                                getLocalDateTime(selection
                                        .getTimestamp(3))
                        )
                );
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (var statement = cn.createStatement()) {
            var selection = statement.executeQuery(String.format(
                            "select * from items where id = ?", id
                    )
            );
            if (selection.next()) {
                 item = new Item(selection.getInt(1),
                     selection.getString(2),
                     getLocalDateTime(selection
                        .getTimestamp(3)
                     )
                );
            }
        }
        return item;
    }

    private LocalDateTime getLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}