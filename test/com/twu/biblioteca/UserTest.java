package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class UserTest {

    User myFirstUser;

    @Before
    public void setUp() throws Exception {
        myFirstUser = new User("123-4567", "User One", "Email", "Phone");
    }

    @Test
    public void testUserHasCorrectLibraryNumber() throws Exception {
        assertEquals("123-4567", myFirstUser.getLibraryNumber());
    }

    @Test
    public void testUserHasCorrectPassword() throws Exception {
    }

    @Test
    public void testUserHasCorrectName() throws Exception {
        assertEquals("User One", myFirstUser.getName());
    }

    @Test
    public void testUserHasCorrectEmail() throws Exception {
        assertEquals("Email", myFirstUser.getEmail());
    }

    @Test
    public void testUserHasCorrectPhoneNumber() throws Exception {
        assertEquals("Phone", myFirstUser.getPhoneNumber());
    }
}
