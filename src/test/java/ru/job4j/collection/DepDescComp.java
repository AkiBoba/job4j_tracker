package ru.job4j.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return 0;
//        Iterator<String> oi1 = List.of(o1.split("/")).listIterator();
//        Iterator<String> oi2 = List.of(o2.split("/")).listIterator();
//        while (oi1.hasNext() && oi2.hasNext()) {
//            int res = oi2.next().compareTo(oi1.next());
//            if (res == 0) {
//                res = oi1.next().compareTo(oi2.next());
//                if (res != 0) {
//                    return res;
//                }
//
//            }
//        } return res;
    }
}
