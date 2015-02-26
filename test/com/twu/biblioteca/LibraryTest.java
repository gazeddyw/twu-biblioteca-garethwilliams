package com.twu.biblioteca;

import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class LibraryTest {

    String validBookTitle;
    String validMovieTitle;
    String invalidItemTitle;

    @Before
    public void setUp() throws Exception {
        validBookTitle = "Book 0";
        validMovieTitle = "Movie 0";
        invalidItemTitle = "Invalid";
    }

    @Test
    public void shouldValidateCorrectLibraryNumber() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateLibraryNumber("123-4567")).thenReturn(true);
        assertTrue(mockLibrary.validateLibraryNumber("123-4567"));
        verify(mockLibrary).validateLibraryNumber("123-4567");
    }

    @Test
    public void shouldInvalidateIncorrectLibraryNumber() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateLibraryNumber("1234567")).thenReturn(false);
        assertFalse(mockLibrary.validateLibraryNumber("1234567"));
        verify(mockLibrary).validateLibraryNumber("1234567");
    }

    @Test
    public void shouldFindUserByLibraryNumberWithCorrectNumber() throws Exception {
        User testUser = new User("123-4567", "", "", "", "");
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.findUserByLibraryNumber("123-4567")).thenReturn(testUser);
        assertEquals(testUser, mockLibrary.findUserByLibraryNumber("123-4567"));
        verify(mockLibrary).findUserByLibraryNumber("123-4567");
    }

    @Test
    public void shouldValidateUserWithCorrectCredentials() throws Exception {
        User mockUser = mock(User.class);
        when(mockUser.getPassword()).thenReturn("password");
        String password = mockUser.getPassword();
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateUserCredentials(mockUser, password)).thenReturn(true);
        assertTrue(mockLibrary.validateUserCredentials(mockUser, password));
        verify(mockUser).getPassword();
        verify(mockLibrary).validateUserCredentials(mockUser, password);
    }

    @Test
    public void shouldInvalidateUserWithIncorrectCredentials() throws Exception {
        User mockUser = mock(User.class);
        when(mockUser.getPassword()).thenReturn("password");
        String incorrectPass = "incorrect_pass";
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateUserCredentials(mockUser, incorrectPass)).thenReturn(false);
        assertFalse(mockLibrary.validateUserCredentials(mockUser, incorrectPass));
        verify(mockLibrary).validateUserCredentials(mockUser, incorrectPass);
    }

    @Test
    public void shouldCheckOutValidBookWithCorrectName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(validBookTitle))
                .thenReturn("Thank you! Enjoy the book.");
        assertEquals("Thank you! Enjoy the book.",
                mockLibrary.validateAndCheckOutBook(validBookTitle));
        verify(mockLibrary).validateAndCheckOutBook(validBookTitle);
    }

    @Test
    public void shouldCheckOutValidMovieWithCorrectName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(validMovieTitle))
                .thenReturn("Thank you! Enjoy the movie.");
        assertEquals("Thank you! Enjoy the movie.",
                mockLibrary.validateAndCheckOutMovie(validMovieTitle));
        verify(mockLibrary).validateAndCheckOutMovie(validMovieTitle);
    }

    @Test
    public void shouldNotCheckOutValidBookAlreadyCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(validBookTitle))
                .thenReturn("That book is currently checked out.");
        assertEquals("That book is currently checked out.",
                mockLibrary.validateAndCheckOutBook(validBookTitle));
        verify(mockLibrary).validateAndCheckOutBook(validBookTitle);
    }

    @Test
    public void shouldNotCheckOutValidMovieAlreadyCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(validMovieTitle))
                .thenReturn("That movie is currently checked out.");
        assertEquals("That movie is currently checked out.",
                mockLibrary.validateAndCheckOutMovie(validMovieTitle));
        verify(mockLibrary).validateAndCheckOutMovie(validMovieTitle);
    }

    @Test
    public void shouldNotCheckOutBookWithInvalidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(invalidItemTitle))
                .thenReturn("That book is not available.");
        assertEquals("That book is not available.",
                mockLibrary.validateAndCheckOutBook(invalidItemTitle));
        verify(mockLibrary).validateAndCheckOutBook(invalidItemTitle);
    }

    @Test
    public void shouldNotCheckOutMovieWithInvalidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(invalidItemTitle))
                .thenReturn("That movie is not available.");
        assertEquals("That movie is not available.",
                mockLibrary.validateAndCheckOutMovie(invalidItemTitle));
        verify(mockLibrary).validateAndCheckOutMovie(invalidItemTitle);
    }

    @Test
    public void shouldCheckInBookWithValidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(validBookTitle))
                .thenReturn("Thank you for returning the book.");
        assertEquals("Thank you for returning the book.",
                mockLibrary.validateAndCheckInBook(validBookTitle));
        verify(mockLibrary).validateAndCheckInBook(validBookTitle);
    }

    @Test
    public void shouldCheckInMovieWithValidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(validMovieTitle))
                .thenReturn("Thank you for returning the movie.");
        assertEquals("Thank you for returning the movie.",
                mockLibrary.validateAndCheckInMovie(validMovieTitle));
        verify(mockLibrary).validateAndCheckInMovie(validMovieTitle);
    }

    @Test
    public void shouldNotCheckInValidBookNotCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(validBookTitle))
                .thenReturn("That book is not currently checked out.");
        assertEquals("That book is not currently checked out.",
                mockLibrary.validateAndCheckInBook(validBookTitle));
        verify(mockLibrary).validateAndCheckInBook(validBookTitle);
    }

    @Test
    public void shouldNotCheckInValidMovieNotCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(validMovieTitle))
                .thenReturn("That movie is not currently checked out.");
        assertEquals("That movie is not currently checked out.",
                mockLibrary.validateAndCheckInMovie(validMovieTitle));
        verify(mockLibrary).validateAndCheckInMovie(validMovieTitle);
    }

    @Test
    public void shouldNotCheckInInvalidBook() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(invalidItemTitle))
                .thenReturn("That is not a valid book to return.");
        assertEquals("That is not a valid book to return.",
                mockLibrary.validateAndCheckInBook(invalidItemTitle));
        verify(mockLibrary).validateAndCheckInBook(invalidItemTitle);
    }

    @Test
    public void shouldNotCheckInInvalidMovie() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(invalidItemTitle))
                .thenReturn("That is not a valid movie to return.");
        assertEquals("That is not a valid movie to return.",
                mockLibrary.validateAndCheckInMovie(invalidItemTitle));
        verify(mockLibrary).validateAndCheckInMovie(invalidItemTitle);
    }

    @Test
    public void shouldNotCheckInBookCheckedOutByOtherUser() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(validBookTitle))
                .thenReturn("That is not a valid book to return.");
        assertEquals("That is not a valid book to return.",
                mockLibrary.validateAndCheckInBook(validBookTitle));
        verify(mockLibrary).validateAndCheckInBook(validBookTitle);
    }

    @Test
    public void shouldNotCheckInMovieCheckedOutByOtherUser() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(validMovieTitle))
                .thenReturn("That is not a valid movie to return.");
        assertEquals("That is not a valid movie to return.",
                mockLibrary.validateAndCheckInMovie(validMovieTitle));
        verify(mockLibrary).validateAndCheckInMovie(validMovieTitle);
    }
}
