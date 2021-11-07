package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vladimir Likhachev
 */
public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer first = 1;
        Integer second = 2;
        int rsl = first.compareTo(second);
        System.out.println(rsl);
    }
}
