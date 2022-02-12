package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Vladimir Likhachev
 */
public class SortByNameItemTest {

    @Test
    public void compare() {
        Item first = new Item(1, "Jenya");
        Item second = new Item(6, "Ivan");
        Item third = new Item(3, "Petr");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);
        List<Item> expected = List.of(second, first, third);
        items.sort(new SortByNameItem());
        assertEquals(expected, items);
    }

    @Test
    public void compareReversed() {
        Item first = new Item(1, "Jenya");
        Item second = new Item(6, "Ivan");
        Item third = new Item(3, "Petr");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);
        List<Item> expected = List.of(third, first, second);
        items.sort(new SortByReversNameItem());
        assertEquals(expected, items);
    }
}