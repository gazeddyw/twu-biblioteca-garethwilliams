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

    private List<Book> libraryBooks;
    
    @Before
    public void setUp() throws Exception {
        libraryBooks = new ArrayList<Book>();
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }
}
