package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vladimir Likhachev
 */
public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );

        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
    }
}
