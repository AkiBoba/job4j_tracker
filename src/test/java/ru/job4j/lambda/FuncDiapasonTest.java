package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Vladimir Likhachev
 */
public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenIndicativeResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}