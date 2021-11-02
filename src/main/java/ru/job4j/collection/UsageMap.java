package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> collections = new HashMap<>();
        collections.put("yo1141@ya.ru", "Vladimir L");
        collections.put("lettervl@ya.ru", "Vladimir N L");
        for (String key : collections.keySet()) {
            String value = collections.get(key);
            System.out.println("For key: " + key + " Value is: " + value);
        }
    }
}
