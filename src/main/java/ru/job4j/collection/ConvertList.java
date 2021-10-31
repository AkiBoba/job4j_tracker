package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Likhachev
 */
public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] arr : list) {
            for (int i : arr) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
