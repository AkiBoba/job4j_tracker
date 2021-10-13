package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    /**
     * @param name
     * @param surname
     * @param birthday
     * @param direction
     * @param qualification
     * @param experience
     * @param language
     */
    public Programmer(String name, String surname,
                      int birthday, String direction, String qualification, int experience,
                      String language) {
        super(name, surname, birthday, direction, qualification, experience);
        this.language = language;
    }

    public void coding(String[] args) {
    }
}