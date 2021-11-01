package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * @author Vladimir Likhachev
 */
public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task string : list) {
            numbers.add(string.getNumber());
        }
        return numbers;
    }
}
