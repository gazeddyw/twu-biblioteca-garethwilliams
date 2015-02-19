package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class LibraryTest {

    Library lib;
    String bookTitle;

    @Before
    public void setUp() throws Exception {
        lib = new Library();
        lib.initialiseLibraryBookList();
        bookTitle = "Title 0";
    }

    @Test
    public void testInitialLibraryBooksListIsEmpty() {
        assertEquals(true, lib.getLibraryBookList().isEmpty());
    }

    @Test
    public void testInitialiseLibraryBookList() {
        assertEquals(10, lib.getLibraryBookList().size());
    }

    @Test
    public void testAddBookToLibraryBooksList() {
        Book book = new Book("Title", "Author", 2010);
        lib.getLibraryBookList().add(book);
        assertEquals(11, lib.getLibraryBookList().size());
    }

    @Test
    public void testCheckInValidBook() {
        lib.getLibraryBookList().get(0).checkOut();
        assertEquals("Thank you for returning the book.", lib.validateBookForCheckIn(bookTitle));
    }

    @Test
    public void testCheckInValidBookNotCheckedOut() {
        lib.getLibraryBookList().get(1).checkOut();
        assertEquals("That book is not currently checked out.", lib.validateBookForCheckIn(bookTitle));
    }

    @Test
    public void testCheckInInvalidBook() {
        String bookTitle = "Incorrect";
        assertEquals("That is not a valid book to return.", lib.validateBookForCheckIn(bookTitle));
    }

    @Test
    public void testFindBookByName() {
    }
}
