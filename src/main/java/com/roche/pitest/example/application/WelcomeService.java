package com.roche.pitest.example.application;

import com.roche.pitest.example.model.Person;
import org.springframework.stereotype.Service;

/**
 * Welcome Service
 */
@Service
public class WelcomeService {

    public String welcomeUser(Person person) {
        return "Welcome: " + person.getFullName() + "!";
    }

    public int calculateDiscount(Person person) {
        if (person.getAge() < 7) {
            return 50;
        } else if (person.getAge() < 18) {
            return 30;
        }
        return 0;
    }
}
