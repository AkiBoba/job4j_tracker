package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return  y - x;
    }

    public int multiply(int y) {
        return  y * x;
    }

    public int divide(int y) {
        return  y / x;
    }

    public int sumAllOperation(int y) {
        return  sum(y) + minus(y)
                + divide(y) + multiply(y);
    }

    public static void main(String[] args) {

        int result = sum(10);
        Calculator calculator = new Calculator();
        System.out.println("Результат выполнения sum: " + result);
        result = minus(10);
        System.out.println("Результат выполнения minus: " + result);
        result = calculator.multiply(10);
        System.out.println("Результат выполнения multiply: " + result);
        result = calculator.divide(10);
        System.out.println("Результат выполнения divide: " + result);
        result = calculator.sumAllOperation(10);
        System.out.println("Результат выполнения sumAllOperation: " + result);
    }
}
