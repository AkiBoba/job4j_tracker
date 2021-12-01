package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vladimir Likhachev
 */
public class Matrix {
    public List<Integer> toList(Integer[][] integer) {

        return Stream.of(integer)
                .flatMap(Arrays::stream)
                .collect(
                        Collectors.toList()
                );
    }
}
