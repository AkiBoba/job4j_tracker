package ru.job4j.poly;

/**
 * @author Vladimir Likhachev
 */
public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": бип-бип");
    }
}
