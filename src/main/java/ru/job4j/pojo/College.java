package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 * @author Vladimir Likhachev
 */
public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setGroup(1);
        student.setDateIn(LocalDateTime.now());
        LocalDateTime currentDateTime = student.getDateIn();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDateTimeFormat = currentDateTime.format(formatter);

        System.out.println(student.getName() + " " + student.getSurname()
                + System.lineSeparator() + "Group: " + student.getGroup()
                + System.lineSeparator() + "Starting study: " + currentDateTimeFormat);
    }
}
