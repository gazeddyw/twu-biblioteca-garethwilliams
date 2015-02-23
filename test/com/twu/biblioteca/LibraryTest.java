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
    String invalidBookTitle;

    @Before
    public void setUp() throws Exception {
        lib = new Library();
        lib.initialiseLibraryBookList();
        validBookTitle = "Title 0";
        invalidBookTitle = "Invalid";
    }

    @Test
    public void testInitialiseLibraryBookList() {
        assertEquals(10, Library.getLibraryBookList().size());
    }

    @Test
    public void testCheckOutValidBookByName() {
        assertEquals("Thank you! Enjoy the book.",
                Library.validateBookForCheckOut(validBookTitle));
    }

    @Test
    public void testCheckOutValidBookAlreadyCheckedOut() {
        Library.validateBookForCheckOut(validBookTitle);
        assertEquals("That book is currently checked out.",
                Library.validateBookForCheckOut(validBookTitle));
    }

    @Test
    public void testCheckOutInvalidBookByName() {
        assertEquals("That book is not available.",
                Library.validateBookForCheckOut(invalidBookTitle));
    }

    @Test
    public void testCheckInValidBook() {
        Library.getLibraryBookList().get(0).checkOut();
        assertEquals("Thank you for returning the book.", Library.validateBookForCheckIn(validBookTitle));
    }

    @Test
    public void testCheckInValidBookNotCheckedOut() {
        Library.getLibraryBookList().get(1).checkOut();
        assertEquals("That book is not currently checked out.", Library.validateBookForCheckIn(validBookTitle));
    }

    @Test
    public void testCheckInInvalidBook() {
        String bookTitle = "Incorrect";
        assertEquals("That is not a valid book to return.", Library.validateBookForCheckIn(bookTitle));
    }
}
