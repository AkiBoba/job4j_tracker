package ru.job4j.poly;

/**
 * @author Vladimir Likhachev
 */
public interface Transport {
    public void go();

    public void passengers(int count);

    public Double load(int gas);
}
