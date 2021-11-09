package ru.job4j.collection;

import java.util.Comparator;
/**
 * @author Vladimir Likhachev
 */
public class StringCharCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int res = 0;
        for (int ind = 0; ind < left.length(); ind++) {
            res = Character.compare(left.charAt(ind), right.charAt(ind));
            if (res != 0) {
                break;
            }
        }
        return res;
    }
}
