package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String forAge;

    public Surgeon(String name, String surname,
                   int birthday, String direction, String qualification,
                   int experience, String forAge) {
        super(name, surname, birthday, direction, qualification, experience);
        this.forAge = forAge;
    }

    public void operate(String[] args) {
    }
}
