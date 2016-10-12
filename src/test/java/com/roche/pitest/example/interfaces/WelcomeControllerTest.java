package com.roche.pitest.example.interfaces;


import com.roche.pitest.example.application.WelcomeService;
import com.roche.pitest.example.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Welcome Controller Test
 */
public class WelcomeControllerTest {

    private final WelcomeService welcomeService = mock(WelcomeService.class);
    private WelcomeController welcomeController = new WelcomeController(welcomeService);

/*    @Test
    public void welcomeMessageTest() {
        // given
        Person testUser = new Person("Mateusz", "Szewczyk", 18);

        when(welcomeService.welcomeUser(testUser)).thenReturn("Welcome");
        when(welcomeService.calculateDiscount(testUser)).thenReturn(100);

        // when
        String welcomeMessage = welcomeController.welcomeUser(testUser.getFirstname(), testUser.getLastname(), testUser.getAge());

        //then
        verify(welcomeService, times(1)).welcomeUser(testUser);
        verify(welcomeService, times(1)).calculateDiscount(testUser);
        verifyNoMoreInteractions(welcomeService);

        assertEquals(welcomeMessage, "Welcome<br/>Discount: 100");
    }*/

    @Test
    public void welcomeMessageGenericTest() {
        // given
        when(welcomeService.welcomeUser(any())).thenReturn("Welcome");
        when(welcomeService.calculateDiscount(any())).thenReturn(100);

        // when
        welcomeController.welcomeUser(null, null, null);

        //then
        verify(welcomeService, times(1)).welcomeUser(any());
        verify(welcomeService, times(1)).calculateDiscount(any());
        verifyNoMoreInteractions(welcomeService);
    }
}