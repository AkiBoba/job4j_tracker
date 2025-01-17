package ru.job4j.collection;

import java.util.HashSet;

/**
 * @author Vladimir Likhachev
 */
public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String str : origin) {
            check.add(str);
        }
        for (String txt : text) {
            if (!check.contains(txt)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
