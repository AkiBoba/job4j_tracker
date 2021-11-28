package ru.job4j.lambda;

import java.util.Comparator;
/**
 * @author Vladimir Likhachev
 */
public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> stringComparator = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
    }
}
