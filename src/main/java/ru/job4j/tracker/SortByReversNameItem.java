package ru.job4j.tracker;

import java.util.Comparator;
/**
 * @author Vladimir Likhachev
 */
public class SortByReversNameItem implements Comparator<Item> {

    @Override
    public int compare(Item o2, Item o1) {
        return o1.getName().compareTo(o2.getName());
    }
}
