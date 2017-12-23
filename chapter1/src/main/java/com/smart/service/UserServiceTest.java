package com.smart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {

        boolean b1 = userService.hasMatchUser("sxsexe1", "pwd1");
        boolean b2 = userService.hasMatchUser("sxsexe2", "pwd2");
        assertTrue(b1);
        assertTrue(b2);

        System.out.println("TestCase: hasMatchUser test SUCCESS");

    }


}
