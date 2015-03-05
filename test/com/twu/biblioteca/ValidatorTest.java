package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Gareth Williams on 05/03/15.
 */
public class ValidatorTest {

    private Validator validator;
    private Library library;

    @Rule
    public ExpectedException exception = org.junit.rules.ExpectedException.none();

    @Mock private LibraryLists mockLibraryLists;
    @Mock private User mockUser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        library = new Library(mockLibraryLists);
        validator = new Validator();
    }

    @Test
    public void shouldValidateCorrectLibraryNumber() throws Exception {
        when(mockLibraryLists.getUsers()).thenReturn(TestData.setupUsers());
        assertTrue(validator.validateLibraryNumber("123-4567"));
    }

    @Test
    public void shouldInvalidateIncorrectLibraryNumber() throws Exception {
        when(mockLibraryLists.getUsers()).thenReturn(TestData.setupUsers());
        assertFalse(validator.validateLibraryNumber("1234567"));
    }

    @Test
    public void shouldFindUserByLibraryNumberWithCorrectNumber() throws Exception {
        when(mockLibraryLists.getUsers()).thenReturn(TestData.setupUsers());
        assertEquals(mockLibraryLists.getUsers().get(0), validator.findUserByLibraryNumber("123-4567"));
    }

    @Test
    public void shouldValidateUserWithCorrectCredentials() throws Exception {
        when(mockLibraryLists.getUsers()).thenReturn(TestData.setupUsers());
        assertTrue(validator.validateUserCredentials(TestData.setupUsers().get(0),
                "password0"));
    }

    @Test
    public void shouldInvalidateUserWithIncorrectCredentials() throws Exception {
        when(mockLibraryLists.getUsers()).thenReturn(TestData.setupUsers());
        when(mockUser.getPassword()).thenReturn("password");
        String incorrectPass = "incorrect_pass";
        assertFalse(validator.validateUserCredentials(mockUser, incorrectPass));
    }

    @Test
    public void shouldFindBookByTitleWithCorrectTitle() throws Exception {
        when(mockLibraryLists.getBooks()).thenReturn(TestData.setupBooks());
        assertEquals(mockLibraryLists.getBooks().get(0), validator.findBookByTitle("Book 0"));
    }

    @Test
    public void shouldNotFindBookByTitleWithIncorrectTitle() throws Exception {
        exception.expect(NoSuchElementException.class);
        when(mockLibraryLists.getBooks()).thenReturn(TestData.setupBooks());
        validator.findBookByTitle("Incorrect Title");
    }
}
