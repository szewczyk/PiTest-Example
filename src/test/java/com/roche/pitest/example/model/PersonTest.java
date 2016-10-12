package com.roche.pitest.example.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Person test
 */
public class PersonTest {
    @Test
    public void getFirstName() throws Exception {
        // given
        String firstName = "Mateusz";

        // when
        Person subject = new Person(firstName, null, null);

        // then
        //assertEquals(subject.getFirstname(), firstName);
    }

    @Test
    public void getLastName() throws Exception {
        // given
        String lastName = "Szewczyk";

        // when
        Person subject = new Person(null, lastName, null);

        // then
        //assertEquals(subject.getLastname(), lastName);
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        EqualsVerifier.forClass(Person.class).verify();
    }
}