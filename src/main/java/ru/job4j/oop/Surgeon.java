package ru.job4j.oop;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education,
                   int birthday, String direction, String qualification, int experience) {
        super(name, surname, education, birthday, direction, qualification, experience);
    }

    public void operate(String[] args) {
    }
}
