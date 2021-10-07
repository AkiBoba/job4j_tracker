package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
        active = true;
        status = 1;
        message = "sos";
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("String: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error err = new Error();
        err.message = "coc";
        err.status = 2;
        err.active = true;
        Error er = new Error();
        er.message = "tos";
        er.status = 3;
        er.active = false;
        error.printInfo();
        err.printInfo();
        er.printInfo();
    }
}
