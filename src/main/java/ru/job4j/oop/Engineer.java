package ru.job4j.oop;

/**
 * @author Vladimir Likhachev
 */
public class Engineer extends Profession {
    private String direction;
    private String qualification;
    private int experience;

    public Engineer(String name, String surname, String education, int birthday, String direction,
                    String qualification, int experience) {
        super(name, surname, education, birthday);
        this.direction = direction;
        this.qualification = qualification;
        this.experience = experience;
    }

    public void todo() {
        System.out.println(this.getName() + "develop");
    }
}


