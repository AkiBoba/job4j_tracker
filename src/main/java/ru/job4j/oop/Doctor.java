package ru.job4j.oop;

/**
 * @author Vladimir Likhachev
 */

public class Doctor extends Profession {
    private String direction;
    private String qualification;
    private int experience;

    public Doctor(String name, String surname, int birthday, String direction,
                  String qualification, int experience) {
        super(name, surname, birthday);
        this.direction = direction;
        this.qualification = qualification;
        this.experience = experience;
    }

    public void todo() {
        System.out.println(this.getName() + "heal");
    }
}

