package ru.job4j.poly;

/**
 * @author Vladimir Likhachev
 */
public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажиров в автобусе: " + count);
    }

    @Override
    public Double load(int gas) {
        return null;
    }
}
