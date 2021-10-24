package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class FactRec {
    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(0);
        System.out.println(rsl);
    }
}
