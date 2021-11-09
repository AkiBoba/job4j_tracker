package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    static int comchar(String left, String right) {
        int res = 0;
        for (int ind = 0; ind < left.length(); ind++) {
            res = Character.compare(left.charAt(ind), right.charAt(ind));
            if (res != 0) {
                break;
            }
        }
        return res;
    }

    @Override
    public int compare(String left, String right) {
        int resurs = comchar(left, right);
        if (resurs == 0) {
            resurs = Integer.compare(left.length(), right.length());
        }
        return resurs;
    }
}
