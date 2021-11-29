package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, -4, 2, -5, 3, -3, 4, 5);
        list = list.stream().filter(el -> el >= 0).collect(Collectors.toList());
    }
}
