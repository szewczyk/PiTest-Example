package com.roche.pitest.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

import static org.junit.Assert.*;

/**
 * PiTestExampleApplication test
 */
@RunWith(PowerMockRunner.class)
public class PiTestExampleApplicationTest {

    @PrepareForTest({ SpringApplication.class })
    @Test
    public void main() throws Exception {
        PowerMockito.mockStatic(SpringApplication.class);

        String[] args = new String[]{"test args"};
        new PiTestExampleApplication().main(args);

        PowerMockito.verifyStatic();
        SpringApplication.run(PiTestExampleApplication.class, args);
    }

}