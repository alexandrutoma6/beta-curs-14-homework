package org.beta;

import org.assertj.core.api.Assertions;
import org.beta.exceptions.IdNotFoundException;
import org.beta.exceptions.InvalidParameterException;
import org.beta.exceptions.ObjectNotFoundInListException;
import org.beta.models.Person;
import org.beta.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        PersonService.resetIdCounter();
        personService = new PersonService();

        personService.addPerson(new Person("Alex", 21));
        personService.addPerson(new Person("Ana", 22));
        personService.addPerson(new Person("Mihai", 23));
    }

    @Test
    @DisplayName("INSTANTIATE CLASS")
    public void instantiateClass() {
        new PersonService();
    }

    @Test
    @DisplayName("CALL addPerson() METHOD")
    public void callAddMethod() {
        personService.addPerson(new Person("John", 30));
    }

    @Test
    @DisplayName("CALL removePerson() METHOD")
    public void callRemoveMethod() {
        personService.removePerson(1);
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF ID IS NOT FOUND IN THE LIST")
    public void methodThrowsExceptionIfTheIDIsNotFound() {
        org.junit.jupiter.api.Assertions.assertThrows(IdNotFoundException.class, () -> personService.removePerson(99));
    }

    @Test
    @DisplayName("CALL METHOD THAT RETURNS LIST OF PERSONS")
    public void callGetAllPersons() {
        List<Person> allPersons = personService.getAllPersons();

        List<Person> expectedPersons = List.of(
                new Person(1, "Alex", 21),
                new Person(2, "Ana", 22),
                new Person(3, "Mihai", 23)
        );

        Assertions.assertThat(allPersons).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("CALL METHOD THAT RETURNS LIST OF NAME OF PERSONS")
    public void callGetAllPersonNames() {
        List<String> allPersonNames = personService.getAllPersonNames();

        List<String> expectedPersonsNames = List.of("Alex", "Ana", "Mihai");

        Assertions.assertThat(allPersonNames).isEqualTo(expectedPersonsNames);
    }

    @Test
    @DisplayName("CALL METHOD THAT RETURNS LIST OF PERSONS OLDER THAN AN AGE")
    public void callGetPersonsOlderThan() {
        List<Person> allPersonsOlderThan = personService.getPersonsOlderThan(22);

        List<Person> expectedPersons = List.of(
                new Person(3, "Mihai", 23)
        );

        Assertions.assertThat(allPersonsOlderThan).isEqualTo(expectedPersons);
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF THE AGE PARAMETER IS INVALID ON METHOD getPersonsOlderThan()")
    public void methodThrowsExceptionIfAgeIsInvalid() {
        org.junit.jupiter.api.Assertions.assertThrows(InvalidParameterException.class, () -> personService.getPersonsOlderThan(-22));
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF THE PERSON WITH name IS NOT IN THE LIST IN getPerson()")
    public void methodThrowsExceptionIfNameIsNotFoundInList() {
        org.junit.jupiter.api.Assertions.assertThrows(ObjectNotFoundInListException.class, () -> personService.getPerson("NonexistentName"));
    }

    @Test
    @DisplayName("THROWS AN EXCEPTION IF THE PERSON WITH id IS NOT IN THE LIST IN getPersonById()")
    public void methodThrowsExceptionIfIdIsNotFoundInList() {
        org.junit.jupiter.api.Assertions.assertThrows(IdNotFoundException.class, () -> personService.getPersonById(99));
    }
}
