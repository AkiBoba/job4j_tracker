package ru.job4j.collection;

import java.util.HashSet;

/**
 * @author Vladimir Likhachev
 */
public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String string : autos) {
            System.out.println(string);
        }
    }
}
