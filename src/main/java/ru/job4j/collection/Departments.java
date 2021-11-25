package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vladimir Likhachev
 */
public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp1 = new LinkedHashSet<>();
        Set<String> tmp2 = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (el.contains("1")) {
                    tmp1.add(el);
                }
                tmp2.add(el);
            }
        }
        return new ArrayList<>(tmp1);
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}
