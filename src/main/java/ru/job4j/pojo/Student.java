package ru.job4j.pojo;

import java.util.Date;
import java.time.LocalDateTime;
/**
 * @author Vladimir Likhachev
 */
public class Student {

    private String name;
    private String surname;
    private int group;
    private java.time.LocalDateTime dateIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }
}
