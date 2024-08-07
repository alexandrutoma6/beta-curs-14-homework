package org.beta;

import org.assertj.core.api.Assertions;
import org.beta.exceptions.InvalidParameterException;
import org.beta.exceptions.NullParameterException;
import org.beta.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    @DisplayName("INSTANTIATE CLASS")
    public void instantiateClass() {
        Person person = new Person("Alex", 15);
    }

    @Test
    @DisplayName("CREATE A PERSON WITH VALID PARAMETERS")
    public void createPerson() {
        Person person = new Person("Alex", 15);
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF THE NAME PARAMETER IS NULL")
    public void methodThrowsExceptionOnNullParameterForCreatingPerson() {
        org.junit.jupiter.api.Assertions.assertThrows(NullParameterException.class, () -> new Person(null, 20));
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF THE AGE PARAMETER IS INVALID")
    public void methodThrowsExceptionOniNVALIDParameterForCreatingPerson() {
        org.junit.jupiter.api.Assertions.assertThrows(InvalidParameterException.class, () -> new Person("Alex", -2));
    }
}
