package org.beta.models;

import org.beta.exceptions.InvalidParameterException;
import org.beta.exceptions.NullParameterException;

public record Person(
        Integer id,
        String name,
        int age
) {
    // Constructor with id
    public Person(Integer id, String name, int age) {
        this.id = id;
        this.name = validateName(name);
        this.age = validateAge(age);
    }

    public Person(String name, int age) {
        this(null, validateName(name), validateAge(age));
    }


    private static String validateName(String name) {
        if (name == null) {
            throw new NullParameterException("The parameter is null");
        }
        return name;
    }

    private static int validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParameterException("Invalid parameter");
        }
        return age;
    }
}
