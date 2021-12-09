package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = value.split("/")[0];
            tmp.add(start);
            int len = value.split("/").length;
            for (int i = 1; i < len; i++) {
                tmp.add(start + "/" + value.split("/")[i]);
                start += "/" + value.split("/")[i];
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
