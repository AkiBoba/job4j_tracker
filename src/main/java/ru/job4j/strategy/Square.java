package ru.job4j.strategy;

/**
 * @author Vladimir Likhachev
 */
public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "_______" + ln
                + "|     |" + ln
                + "|_____|" + ln;
    }
}
