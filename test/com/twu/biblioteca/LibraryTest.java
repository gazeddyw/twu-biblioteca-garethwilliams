package com.twu.biblioteca;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class LibraryTest {

    private Library library;

    private String validBookTitle;
    private String validMovieTitle;
    private String invalidItemTitle;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock private LibraryLists mockLibraryLists;
    @Mock private Validator mockValidator;
    @Mock private User mockUser;
    @Mock private Book mockBook;
    @Mock private Movie mockMovie;
    @Mock private Driver mockDriver;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        library = new Library(mockLibraryLists, mockValidator);
        validBookTitle = "Book 0";
        validMovieTitle = "Movie 0";
        invalidItemTitle = "Invalid";
    }

    @Test
    public void shouldCheckOutValidBookWithCorrectName() throws Exception {
        library.setCurrentUser(mockUser);
        when(mockLibraryLists.getBooks()).thenReturn(TestData.setupBooks());
        List<Book> books = mockLibraryLists.getBooks();
        when(mockValidator.findBookByTitle(validBookTitle)).thenReturn(books.get(0));
        assertEquals("Thank you! Enjoy the book.",
                library.validateAndCheckOutBook(validBookTitle));
        verify(mockUser).addBook(mockLibraryLists.getBooks().get(0));
    }

    @Test
    public void shouldCheckOutValidMovieWithCorrectName() throws Exception {
        library.setCurrentUser(mockUser);
        when(mockLibraryLists.getMovies()).thenReturn(TestData.setupMovies());
        assertEquals("Thank you! Enjoy the movie.",
                library.validateAndCheckOutMovie(validMovieTitle));
        verify(mockUser).addMovie(mockLibraryLists.getMovies().get(0));
    }

    @Test
    public void shouldNotCheckOutValidBookAlreadyCheckedOut() throws Exception {
        library.setCurrentUser(mockUser);
        when(mockLibraryLists.getBooks()).thenReturn(TestData.setupBooks());
        List<Book> books = mockLibraryLists.getBooks();
        when(mockValidator.findBookByTitle(validBookTitle)).thenReturn(books.get(0));
        mockLibraryLists.getBooks().get(0).checkOut();
        assertEquals("That book is currently checked out.",
                library.validateAndCheckOutBook(validBookTitle));
        verify(mockUser, never()).addBook(mockLibraryLists.getBooks().get(0));
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
