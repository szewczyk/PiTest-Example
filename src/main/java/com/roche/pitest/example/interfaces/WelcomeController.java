package com.roche.pitest.example.interfaces;

import com.roche.pitest.example.application.WelcomeService;
import com.roche.pitest.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Simple Welcome Controller
 */
@Controller
public class WelcomeController {

    private static final Logger LOGGER = Logger.getLogger(WelcomeController.class.getName());

    private final WelcomeService welcomeService;

    @Autowired
    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "welcome")
    public String welcomeUser(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname,
                              @RequestParam("age") Integer age) {
        LOGGER.info("Welcoming " + firstname + " " + lastname);

        final Person newUser = new Person(firstname, lastname, age);

        return welcomeService.welcomeUser(newUser) +
                "<br/>Discount: " +
                welcomeService.calculateDiscount(newUser);
    }
}
