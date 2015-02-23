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
    public void testCheckOutValidBookByName() throws Exception {
        assertEquals("Thank you! Enjoy the book.",
                Library.validateBookForCheckOut(validBookTitle));
    }

    @Test
    public void testCheckOutValidMovieByName() throws Exception {
        assertEquals("Thank you! Enjoy the movie.",
                Library.validateMovieForCheckOut(validMovieTitle));
    }

    @Test
    public void testCheckOutValidBookAlreadyCheckedOut() throws Exception {
        Library.validateBookForCheckOut(validBookTitle);
        assertEquals("That book is currently checked out.",
                Library.validateBookForCheckOut(validBookTitle));
    }

    @Test
    public void testCheckOutValidMovieAlreadyCheckedOut() throws Exception {
        Library.validateMovieForCheckOut(validMovieTitle);
        assertEquals("That movie is currently checked out.",
                Library.validateMovieForCheckOut(validMovieTitle));
    }

    @Test
    public void testCheckOutInvalidBookByName() throws Exception {
        assertEquals("That book is not available.",
                Library.validateBookForCheckOut(invalidItemTitle));
    }

    @Test
    public void testCheckOutInvalidMovieByName() throws Exception {
        assertEquals("That movie is not available.",
                Library.validateMovieForCheckOut(invalidItemTitle));
    }

    @Test
    public void testCheckInValidBook() throws Exception {
        Library.getLibraryBookList().get(0).checkOut();
        assertEquals("Thank you for returning the book.",
                Library.validateBookForCheckIn(validBookTitle));
    }

    @Test
    public void testCheckInValidMovie() throws Exception {
        Library.getLibraryMovieList().get(0).checkOut();
        assertEquals("Thank you for returning the movie.",
                Library.validateMovieForCheckIn(validMovieTitle));
    }

    @Test
    public void testCheckInValidBookNotCheckedOut() throws Exception {
        Library.getLibraryBookList().get(1).checkOut();
        assertEquals("That book is not currently checked out.",
                Library.validateBookForCheckIn(validBookTitle));
    }

    @Test
    public void testCheckInValidMovieNotCheckedOut() throws Exception {
        Library.getLibraryMovieList().get(1).checkOut();
        assertEquals("That movie is not currently checked out.",
                Library.validateMovieForCheckIn(validMovieTitle));
    }

    @Test
    public void testCheckInInvalidBook() throws Exception {
        assertEquals("That is not a valid book to return.",
                Library.validateBookForCheckIn(invalidItemTitle));
    }

    @Test
    public void testCheckInInvalidMovie() throws Exception {
        assertEquals("That is not a valid movie to return.",
                Library.validateMovieForCheckIn(invalidItemTitle));
    }
}
