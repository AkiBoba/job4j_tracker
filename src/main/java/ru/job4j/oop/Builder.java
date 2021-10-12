package ru.job4j.oop;

public class Builder extends Engineer {
    private String typeHouse;

    public Builder(String name, String surname, String education,
                    int birthday, String direction, String qualification, int experience) {
        super(name, surname, education, birthday, direction, qualification, experience);
    }

    public void build(String[] args) {
    }
}
