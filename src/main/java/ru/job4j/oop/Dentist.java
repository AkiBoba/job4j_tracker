package ru.job4j.oop;

public class Dentist extends Doctor {
    private String forAge;

    /**
     * @param name
     * @param surname
     * @param birthday
     * @param direction
     * @param qualification
     * @param experience
     * @param forAge
     */
    public Dentist(String name, String surname,
                   int birthday, String direction, String qualification,
                   int experience, String forAge) {
        super(name, surname, birthday, direction, qualification, experience);
        this.forAge = forAge;
    }

    public void bore(String[] args) {
    }
}
