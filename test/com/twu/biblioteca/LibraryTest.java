package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class LibraryTest {

    Library lib;
    String validBookTitle;
    String validMovieTitle;
    String invalidItemTitle;

    @Before
    public void setUp() throws Exception {
        lib = new Library();
        lib.initialiseLibraryBookList();
        lib.initialiseLibraryMovieList();
        lib.initialiseLibraryUserList();
        validBookTitle = "Book 0";
        validMovieTitle = "Movie 0";
        invalidItemTitle = "Invalid";
    }

    @Test
    public void testInitialiseLibraryBookList() throws Exception {
        assertEquals(10, Library.getLibraryBookList().size());
    }

    @Test
    public void testInitialiseLibraryMovieList() throws Exception {
        assertEquals(10, Library.getLibraryMovieList().size());
    }

    @Test
    public void testInitialiseLibraryUserList() throws Exception {
        assertEquals(2, Library.getLibraryUserList().size());
    }

    @Test
    public void testValidateCorrectLibraryNumber() throws Exception {
        assertEquals("Valid library number", Library.validateLibraryNumber("123-4567"));
    }

    @Test
    public void testValidateIncorrectLibraryNumber() throws Exception {
        assertEquals("Invalid library number", Library.validateLibraryNumber("1234567"));
    }

    @Test
    public void testValidateUserWithCorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String password = user.getPassword();
        assertEquals("User logged in", Library.validateUserCredentials(user, password));
    }

    @Test
    public void testValidateUserWithIncorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String incorrectPass = "incorrect_pass";
        assertEquals("Login failed", Library.validateUserCredentials(user, incorrectPass));
    }

    @Test
    public void testCheckOutValidBookByName() throws Exception {
        assertEquals("Thank you! Enjoy the book.",
                Library.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void testCheckOutValidMovieByName() throws Exception {
        assertEquals("Thank you! Enjoy the movie.",
                Library.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void testCheckOutValidBookAlreadyCheckedOut() throws Exception {
        Library.validateAndCheckOutBook(validBookTitle);
        assertEquals("That book is currently checked out.",
                Library.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void testCheckOutValidMovieAlreadyCheckedOut() throws Exception {
        Library.validateAndCheckOutMovie(validMovieTitle);
        assertEquals("That movie is currently checked out.",
                Library.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void testCheckOutInvalidBookByName() throws Exception {
        assertEquals("That book is not available.",
                Library.validateAndCheckOutBook(invalidItemTitle));
    }

    @Test
    public void testCheckOutInvalidMovieByName() throws Exception {
        assertEquals("That movie is not available.",
                Library.validateAndCheckOutMovie(invalidItemTitle));
    }

    @Test
    public void testCheckInValidBook() throws Exception {
        Library.getLibraryBookList().get(0).checkOut();
        assertEquals("Thank you for returning the book.",
                Library.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void testCheckInValidMovie() throws Exception {
        Library.getLibraryMovieList().get(0).checkOut();
        assertEquals("Thank you for returning the movie.",
                Library.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void testCheckInValidBookNotCheckedOut() throws Exception {
        Library.getLibraryBookList().get(1).checkOut();
        assertEquals("That book is not currently checked out.",
                Library.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void testCheckInValidMovieNotCheckedOut() throws Exception {
        Library.getLibraryMovieList().get(1).checkOut();
        assertEquals("That movie is not currently checked out.",
                Library.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void testCheckInInvalidBook() throws Exception {
        assertEquals("That is not a valid book to return.",
                Library.validateAndCheckInBook(invalidItemTitle));
    }

    @Test
    public void testCheckInInvalidMovie() throws Exception {
        assertEquals("That is not a valid movie to return.",
                Library.validateAndCheckInMovie(invalidItemTitle));
    }
}
