package ru.job4j.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Iterator<String> oi1 = List.of(o1.split("/")).listIterator();
        Iterator<String> oi2 = List.of(o2.split("/")).listIterator();
        String soi1 = oi1.next();
        String soi2 = oi2.next();
        int res = soi2.compareTo(soi1);
        if (res != 0) {
            return res;
        } else if (o1.split("/").length == 1 && o2.split("/").length == 1) {
            return res;
        } else if (o1.split("/").length == 1 && o2.split("/").length > 1) {
            res = -1;
            return res;
        } else {
            while (oi1.hasNext() && oi2.hasNext()) {
                res = oi1.next().compareTo(oi2.next());
                if (res != 0) {
                    return res;
                }
            }
        }
        return res;
    }
}
