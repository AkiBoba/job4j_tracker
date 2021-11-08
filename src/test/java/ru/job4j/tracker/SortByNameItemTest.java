package ru.job4j.tracker;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(items, new  SortByNameItem());
        assertEquals(expected, items);
    }

    @Test
    public void compareReversed() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Petr"));
        items.add(new Item(6, "Ivan"));
        items.add(new Item(1, "Jenya"));
        Collections.sort(items, new SortByReversNameItem());
        assertThat(items.get(1).getName(), is("Jenya"));
        assertThat(items.get(0).getName(), is("Petr"));
        assertThat(items.get(2).getName(), is("Ivan"));
    }
}