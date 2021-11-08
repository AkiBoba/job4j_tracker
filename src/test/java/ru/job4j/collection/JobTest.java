package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobTest {
    @Test
    public void whenSortByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Impl task", 1));
        list.sort(new JobSortByPriority());
        assertThat(list.get(0).getPriority(), is(1));
    }

    @Test
    public void whenDescByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("mpl task", 1));
        list.sort(new JobDescByPriority());
        assertThat(list.get(0).getPriority(), is(2));
    }

    @Test
    public void whenSortByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobSortByName());
        assertThat(list.get(0).getName(), is("Fix bug"));
    }

    @Test
    public void whenDescByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobDescByName());
        assertThat(list.get(1).getName(), is("Fix bug"));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(
                new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}