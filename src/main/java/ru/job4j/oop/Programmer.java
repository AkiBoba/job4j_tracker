package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education,
                    int birthday, String direction, String qualification, int experience) {
        super(name, surname, education, birthday, direction, qualification, experience);
    }

    public void coding(String[] args) {
    }
}