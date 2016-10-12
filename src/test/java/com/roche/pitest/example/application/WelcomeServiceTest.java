package com.roche.pitest.example.application;

import com.roche.pitest.example.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * WelcomeServiceTest
 */
public class WelcomeServiceTest {
    private WelcomeService welcomeService = new WelcomeService();

    @Test
    public void welcomeUserTest() throws Exception {
        // given
        //Person person = new Person("Mateusz", "Szewczyk", 18);
        Person person = new Person("Mateusz", "Szewczyk", 22);

        // when
        String message = welcomeService.welcomeUser(person);

        // then
        assertEquals(message, "Welcome: Mateusz Szewczyk!");
    }


    @Test
    public void shouldReturnZeroDiscountForOldPerson() throws Exception {
        // given
        //Person person = new Person("Mateusz", "Szewczyk", 18);
        Person person = new Person("Mateusz", "Szewczyk", 22);

        // when
        int discount = welcomeService.calculateDiscount(person);

        // then
        assertEquals(discount, 0);
    }

    @Test
    public void shouldReturn30DiscountForYoungPerson() throws Exception {
        // given
        //Person person = new Person("Mateusz", "Szewczyk", 7);
        Person person = new Person("Mateusz", "Szewczyk", 15);

        // when
        int discount = welcomeService.calculateDiscount(person);

        // then
        assertTrue(discount > 10);

        //assertEquals(discount, 30);
    }

    @Test
    public void shouldReturn50DiscountForBabiesPerson() throws Exception {
        // given
        //Person person = new Person("Mateusz", "Szewczyk", 0);
        Person person = new Person("Mateusz", "Szewczyk", 3);

        // when
        int discount = welcomeService.calculateDiscount(person);

        // then
        assertTrue(discount > 40);

        //assertEquals(discount, 50);
    }
}