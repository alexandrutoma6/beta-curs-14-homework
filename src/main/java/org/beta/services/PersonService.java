package org.beta.services;

import org.beta.exceptions.IdNotFoundException;
import org.beta.exceptions.InvalidParameterException;
import org.beta.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private final List<Person> list = new ArrayList<>();

    private static int nextId = 1;

    public static void resetIdCounter() {
        nextId = 1;
    }

    public Person addPerson(Person person) {
        Person createdPerson = new Person(nextId++, person.name(), person.age());
        list.add(createdPerson);
        return createdPerson;
    }

    public Person removePerson(int id) {
        for (Person person : list) {
            if (person.id().equals(id)) {
                list.remove(person);
                return person;
            }
        }
        throw new IdNotFoundException();
    }

    public List<Person> getAllPersons() {
        return list;
    }

    public List<String> getAllPersonNames() {
        List<String> result = new ArrayList<>();
        for (Person person : list) {
            result.add(person.name());
        }
        return result;
    }

    public List<Person> getPersonsOlderThan(int age) {
        validate(age);
        List<Person> result = new ArrayList<>(list);
        for (Person person : list) {
            if (person.age() <= age) {
                result.remove(person);
            }
        }
        return result;
    }

    private void validate(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParameterException("Age is invalid");
        }
    }
}
