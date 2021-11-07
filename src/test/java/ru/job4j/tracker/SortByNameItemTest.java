package ru.job4j.tracker;

import org.junit.Test;

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
    public void compareTo() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3,"Petr"));
        items.add(new Item(6,"Ivan"));
        items.add(new Item(1,"Jenya"));
        Collections.sort(items);
        assertThat(items.get(0).getName(), is("Jenya"));
        assertThat(items.get(1).getName(), is("Petr"));
        assertThat(items.get(2).getName(), is("Ivan"));
    }

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3,"Petr"));
        items.add(new Item(6,"Ivan"));
        items.add(new Item(1,"Jenya"));
        Collections.sort(items, new  SortByNameItem());
        assertThat(items.get(1).getName(), is("Jenya"));
        assertThat(items.get(2).getName(), is("Petr"));
        assertThat(items.get(0).getName(), is("Ivan"));
    }

    @Test
    public void compareReversed() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3,"Petr"));
        items.add(new Item(6,"Ivan"));
        items.add(new Item(1,"Jenya"));
        Collections.sort(items, new  SortByNameItem().reversed());
        assertThat(items.get(1).getName(), is("Jenya"));
        assertThat(items.get(0).getName(), is("Petr"));
        assertThat(items.get(2).getName(), is("Ivan"));
    }
}