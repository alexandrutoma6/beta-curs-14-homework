package org.beta.models;

import org.beta.exceptions.InvalidParameterException;
import org.beta.exceptions.NullParameterException;

public record Person(
        int id,
        String name,
        int age
) {
    private static int nextId = 1;

    public Person(String name, int age) {
        this(nextId++, validateName(name), validateAge(age));
    }

    private static String validateName(String name) {
        if (name == null) {
            throw new NullParameterException("The parameter is null");
        }
        return name;
    }

    private static int validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidParameterException("Invalid parameter");
        }
        return age;
    }
}
