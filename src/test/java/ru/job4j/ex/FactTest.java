package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vladimir Likhachev
 */
public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calc() {
        Fact fact = new Fact();
        fact.calc(-1);
    }
}