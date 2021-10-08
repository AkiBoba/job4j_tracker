package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message =  message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("String: " + message);
    }

    public static void main(String[] args) {
        Error er = new Error();
        Error error = new Error(true, 1, "sos");
        Error err = new Error(false, 2, "exe");
        er.printInfo();
        err.printInfo();
        error.printInfo();
    }
}
