package ru.job4j.tracker.store;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

/**
 * @author Vladimir Likhachev
 */
public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest
                .class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        int id = item1.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(IsNull.nullValue()));
    }

    @Test
    public void whenReplace() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item bugItem = new Item("Bug");
        tracker.add(item1);
        int id = item1.getId();
        tracker.replace(id, bugItem);
        assertThat(tracker.findById(id).getName(), is("Bug"));
    }

    @Test
    public void whenTestFindAll() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = List.of(item1, item2, item3);
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName(item1.getName());
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = List.of(item1, item3);
        assertThat(tracker.findByName(item1.getName()), is(result));
    }

    @Test
    public void whenTestFindById() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

}