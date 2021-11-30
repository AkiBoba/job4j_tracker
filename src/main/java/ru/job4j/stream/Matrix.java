package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladimir Likhachev
 */
public class Matrix {
    public List<Integer> toList(List<List<Integer>> matrix) {
        return matrix.stream()
                .flatMap(e -> e.stream())
                .collect(
                        Collectors.toList()
                );
    }
}
