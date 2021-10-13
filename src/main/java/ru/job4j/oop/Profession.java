package ru.job4j.oop;

/**
 * @author Vladimir Likhachev
 */
public class Profession {
    private String name;
    private String surname;
    private int birthday;

    public Profession(String name, String surname, int birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthday() {
        return birthday;
    }
}


