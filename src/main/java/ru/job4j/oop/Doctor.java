package ru.job4j.oop;

/**
 * @author Vladimir Likhachev
 */

public class Doctor extends Profession {
    private String direction;
    private String qualification;
    private int experience;

    public Doctor(String name, String surname, String education, int birthday, String direction,
                  String qualification, int experience) {
        super(name, surname, education, birthday);
        this.direction = direction;
        this.qualification = qualification;
        this.experience = experience;
    }

    public void todo() {
        System.out.println(this.getName() + "heal");
    }
}

class Diagnosis extends Doctor {
    private String equipment;

    public Diagnosis(String name, String surname, String education,
                     int birthday, String direction, String qualification, int experience) {
        super(name, surname, education, birthday, direction, qualification, experience);
    }

    public void heal(String[] args) {
    }
}