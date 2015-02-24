package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        lib = new Library(new LibraryLists());
        validBookTitle = "Book 0";
        validMovieTitle = "Movie 0";
        invalidItemTitle = "Invalid";
    }

    @Test
    public void shouldInitialiseLibraryBookListWithTenBooks() throws Exception {
        assertEquals(10, Library.getLibraryBookList().size());
    }

    @Test
    public void shouldInitialiseLibraryMovieListWithTenMovies() throws Exception {
        assertEquals(10, Library.getLibraryMovieList().size());
    }

    @Test
    public void shouldInitialiseLibraryUserListWithTwoUsers() throws Exception {
        assertEquals(2, Library.getLibraryUserList().size());
    }

    @Test
    public void shouldValidateCorrectLibraryNumber() throws Exception {
        assertTrue(Library.validateLibraryNumber("123-4567"));
    }

    @Test
    public void shouldInvalidateIncorrectLibraryNumber() throws Exception {
        assertFalse(Library.validateLibraryNumber("1234567"));
    }

    @Test
    public void shouldFindUserByLibraryNumberWithCorrectNumber() throws Exception {
        assertEquals(Library.getLibraryUserList().get(0), Library.findUserByLibraryNumber("123-4567"));
    }

    @Test
    public void shouldValidateUserWithCorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String password = user.getPassword();
        assertTrue(Library.validateUserCredentials(user, password));
    }

    @Test
    public void shouldInvalidateUserWithIncorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String incorrectPass = "incorrect_pass";
        assertFalse(Library.validateUserCredentials(user, incorrectPass));
    }

    @Test
    public void shouldCheckOutValidBookWithCorrectName() throws Exception {
        assertEquals("Thank you! Enjoy the book.",
                Library.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void shouldCheckOutValidMovieWithCorrectName() throws Exception {
        assertEquals("Thank you! Enjoy the movie.",
                Library.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckOutValidBookAlreadyCheckedOut() throws Exception {
        Library.validateAndCheckOutBook(validBookTitle);
        assertEquals("That book is currently checked out.",
                Library.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void shouldNotCheckOutValidMovieAlreadyCheckedOut() throws Exception {
        Library.validateAndCheckOutMovie(validMovieTitle);
        assertEquals("That movie is currently checked out.",
                Library.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckOutBookWithInvalidName() throws Exception {
        assertEquals("That book is not available.",
                Library.validateAndCheckOutBook(invalidItemTitle));
    }

    @Test
    public void shouldNotCheckOutMovieWithInvalidName() throws Exception {
        assertEquals("That movie is not available.",
                Library.validateAndCheckOutMovie(invalidItemTitle));
    }

    @Test
    public void shouldCheckInBookWithValidName() throws Exception {
        Library.getLibraryBookList().get(0).checkOut();
        assertEquals("Thank you for returning the book.",
                Library.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void shouldCheckInMovieWithValidName() throws Exception {
        Library.getLibraryMovieList().get(0).checkOut();
        assertEquals("Thank you for returning the movie.",
                Library.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckInValidBookNotCheckedOut() throws Exception {
        Library.getLibraryBookList().get(1).checkOut();
        assertEquals("That book is not currently checked out.",
                Library.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void shouldNotCheckInValidMovieNotCheckedOut() throws Exception {
        Library.getLibraryMovieList().get(1).checkOut();
        assertEquals("That movie is not currently checked out.",
                Library.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckInInvalidBook() throws Exception {
        assertEquals("That is not a valid book to return.",
                Library.validateAndCheckInBook(invalidItemTitle));
    }

    @Test
    public void shouldNotCheckInInvalidMovie() throws Exception {
        assertEquals("That is not a valid movie to return.",
                Library.validateAndCheckInMovie(invalidItemTitle));
    }
}
