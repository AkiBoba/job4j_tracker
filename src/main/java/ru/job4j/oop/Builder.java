package ru.job4j.oop;

public class Builder extends Engineer {
    private String typeHouse;

    /**
     * @param name
     * @param surname
     * @param birthday
     * @param direction
     * @param qualification
     * @param experience
     * @param typeHouse
     */
    public Builder(String name, String surname,
                    int birthday, String direction, String qualification,
                   int experience, String typeHouse) {
        super(name, surname, birthday, direction, qualification, experience);
        this.typeHouse = typeHouse;
    }

    public void build(String[] args) {
    }
}
