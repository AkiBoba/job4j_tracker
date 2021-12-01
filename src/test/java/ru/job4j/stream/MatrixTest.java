package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Vladimir Likhachev
 */
public class MatrixTest {

    @Test
    public void toList() {
        Integer[][] integer = {
                        {1, 2},
                        {3, 4}
                };

        Matrix list = new Matrix();
        List<Integer> rsl = list.toList(integer);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}