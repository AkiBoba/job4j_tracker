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

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}
