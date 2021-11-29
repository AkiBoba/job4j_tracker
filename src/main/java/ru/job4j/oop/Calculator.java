package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return  x - y;
    }

    public static int divide(int y) {
        return  y / x;
    }

    public int sumAllOperation(int y) {
        return  sum(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Результат выполнения sum: " + result);
        result = minus(10);
        System.out.println("Результат выполнения minus: " + result);
        result = divide(10);
        System.out.println("Результат выполнения divide: " + result);
        Calculator calculator = new Calculator();
        result = calculator.sumAllOperation(10);
        System.out.println("Результат выполнения sumAllOperation: " + result);
    }
}
