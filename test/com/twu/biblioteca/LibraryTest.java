package com.twu.biblioteca;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class LibraryTest {

    Library library;
    String validBookTitle;
    String validMovieTitle;
    String invalidItemTitle;

    @Before
    public void setUp() throws Exception {
        library = new Library(new LibraryLists());
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
        assertTrue(library.validateLibraryNumber("123-4567"));
    }

    @Test
    public void shouldInvalidateIncorrectLibraryNumber() throws Exception {
        assertFalse(library.validateLibraryNumber("1234567"));
    }

    @Test
    public void shouldFindUserByLibraryNumberWithCorrectNumber() throws Exception {
        assertEquals(Library.getLibraryUserList().get(0), library.findUserByLibraryNumber("123-4567"));
    }

    @Test
    public void shouldValidateUserWithCorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String password = user.getPassword();
        assertTrue(library.validateUserCredentials(user, password));
    }

    @Test
    public void shouldInvalidateUserWithIncorrectCredentials() throws Exception {
        User user = Library.getLibraryUserList().get(0);
        String incorrectPass = "incorrect_pass";
        assertFalse(library.validateUserCredentials(user, incorrectPass));
    }

    @Test
    public void shouldCheckOutValidBookWithCorrectName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(validBookTitle))
                .thenReturn("Thank you! Enjoy the book.");
        mockLibrary.validateAndCheckOutBook(validBookTitle);
        verify(mockLibrary).validateAndCheckOutBook(validBookTitle);

        assertEquals("Thank you! Enjoy the book.",
                mockLibrary.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void shouldCheckOutValidMovieWithCorrectName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(validMovieTitle))
                .thenReturn("Thank you! Enjoy the movie.");
        mockLibrary.validateAndCheckOutMovie(validMovieTitle);
        verify(mockLibrary).validateAndCheckOutMovie(validMovieTitle);

        assertEquals("Thank you! Enjoy the movie.",
                library.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckOutValidBookAlreadyCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(validBookTitle))
                .thenReturn("That book is currently checked out.");
        mockLibrary.validateAndCheckOutBook(validBookTitle);
        verify(mockLibrary).validateAndCheckOutBook(validBookTitle);
        assertEquals("That book is currently checked out.",
                mockLibrary.validateAndCheckOutBook(validBookTitle));
    }

    @Test
    public void shouldNotCheckOutValidMovieAlreadyCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(validMovieTitle))
                .thenReturn("That movie is currently checked out.");
        mockLibrary.validateAndCheckOutMovie(validMovieTitle);
        verify(mockLibrary).validateAndCheckOutMovie(validMovieTitle);

        assertEquals("That movie is currently checked out.",
                mockLibrary.validateAndCheckOutMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckOutBookWithInvalidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutBook(invalidItemTitle))
                .thenReturn("That book is not available.");
        mockLibrary.validateAndCheckOutBook(invalidItemTitle);
        verify(mockLibrary).validateAndCheckOutBook(invalidItemTitle);

        assertEquals("That book is not available.",
                mockLibrary.validateAndCheckOutBook(invalidItemTitle));
    }

    @Test
    public void shouldNotCheckOutMovieWithInvalidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckOutMovie(invalidItemTitle))
                .thenReturn("That movie is not available.");
        mockLibrary.validateAndCheckOutMovie(invalidItemTitle);
        verify(mockLibrary).validateAndCheckOutMovie(invalidItemTitle);

        assertEquals("That movie is not available.",
                mockLibrary.validateAndCheckOutMovie(invalidItemTitle));
    }

    @Test
    public void shouldCheckInBookWithValidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(validBookTitle))
                .thenReturn("Thank you for returning the book.");
        mockLibrary.validateAndCheckInBook(validBookTitle);
        verify(mockLibrary).validateAndCheckInBook(validBookTitle);

        assertEquals("Thank you for returning the book.",
                mockLibrary.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void shouldCheckInMovieWithValidName() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(validMovieTitle))
                .thenReturn("Thank you for returning the movie.");
        mockLibrary.validateAndCheckInMovie(validMovieTitle);
        verify(mockLibrary).validateAndCheckInMovie(validMovieTitle);

        assertEquals("Thank you for returning the movie.",
                mockLibrary.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckInValidBookNotCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(validBookTitle))
                .thenReturn("That book is not currently checked out.");
        mockLibrary.validateAndCheckInBook(validBookTitle);
        verify(mockLibrary).validateAndCheckInBook(validBookTitle);

        assertEquals("That book is not currently checked out.",
                mockLibrary.validateAndCheckInBook(validBookTitle));
    }

    @Test
    public void shouldNotCheckInValidMovieNotCheckedOut() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(validMovieTitle))
                .thenReturn("That movie is not currently checked out.");
        mockLibrary.validateAndCheckInMovie(validMovieTitle);
        verify(mockLibrary).validateAndCheckInMovie(validMovieTitle);

        assertEquals("That movie is not currently checked out.",
                mockLibrary.validateAndCheckInMovie(validMovieTitle));
    }

    @Test
    public void shouldNotCheckInInvalidBook() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInBook(invalidItemTitle))
                .thenReturn("That is not a valid book to return.");
        mockLibrary.validateAndCheckInBook(invalidItemTitle);
        verify(mockLibrary).validateAndCheckInBook(invalidItemTitle);

        assertEquals("That is not a valid book to return.",
                mockLibrary.validateAndCheckInBook(invalidItemTitle));
    }

    @Test
    public void shouldNotCheckInInvalidMovie() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.validateAndCheckInMovie(invalidItemTitle))
                .thenReturn("That is not a valid movie to return.");
        mockLibrary.validateAndCheckInMovie(invalidItemTitle);
        verify(mockLibrary).validateAndCheckInMovie(invalidItemTitle);

        assertEquals("That is not a valid movie to return.",
                mockLibrary.validateAndCheckInMovie(invalidItemTitle));
    }
}
