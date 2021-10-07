package ru.job4j.oop;

import java.net.SocketOption;

/**
 * @author Vladimir Likhachev
 */
public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("колобок съеден");
        } else {
            System.out.println("колобок сбежал");
        }
    }
}
