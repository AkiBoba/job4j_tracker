package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author Vladimir Likhachev
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> inName = (person) -> person.getName().contains(key);
        Predicate<Person> inSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> inPhone = (person) -> person.getAddress().contains(key);
        Predicate<Person> inAdress = (person) -> person.getPhone().contains(key);
        Predicate<Person> combine = inName.or(inSurname.or(inAdress.or(inPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
