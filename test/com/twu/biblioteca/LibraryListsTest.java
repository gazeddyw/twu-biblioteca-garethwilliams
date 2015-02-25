package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gareth Williams on 2/25/15.
 */
public class LibraryListsTest {

    LibraryLists libraryLists;

    @Before
    public void setUp() throws Exception {
        libraryLists = new LibraryLists();
    }

    @Test
    public void shouldInitialiseLibraryBookListWithTenBooks() throws Exception {
        assertEquals(10, libraryLists.getBooks().size());
    }

    @Test
    public void shouldInitialiseLibraryMovieListWithTenMovies() throws Exception {
        assertEquals(10, libraryLists.getMovies().size());
    }

    @Test
    public void shouldInitialiseLibraryUserListWithTwoUsers() throws Exception {
        assertEquals(2, libraryLists.getUsers().size());
    }
}
