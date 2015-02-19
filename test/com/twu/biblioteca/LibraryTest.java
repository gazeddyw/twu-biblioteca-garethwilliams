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
    private List<Book> libraryBooks;
    
    @Before
    public void setUp() throws Exception {
        lib = new Library();
        libraryBooks = new ArrayList<Book>();
    }

    @Test
    public void testInitialLibraryBooksListIsEmpty() {
        assertEquals(true, lib.getLibraryBookList().isEmpty());
    }

    @Test
    public void testInitialiseLibraryBookList() {
        lib.initialiseLibraryBookList();
        assertEquals(10, lib.getLibraryBookList().size());
    }

    @Test
    public void testAddBookToLibraryBooksList() {
        Book book = new Book("Title", "Author", 2010);
        lib.getLibraryBookList().add(book);
        assertEquals(1, lib.getLibraryBookList().size());
    }

    @Test
    public void testCheckoutBookDecrementsBookList() {
    }

    @Test
    public void testCheckinBookIncrementsBookList() {
    }
}
