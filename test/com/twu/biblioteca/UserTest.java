package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class UserTest {

    User myFirstUser;

    @Before
    public void setUp() throws Exception {
        myFirstUser = new User("123-4567", "password1", "User One", "Email", "Phone");
    }

    @Test
    public void testUserHasCorrectLibraryNumber() throws Exception {
        assertEquals("123-4567", myFirstUser.getLibraryNumber());
    }

    @Test
    public void testUserHasCorrectPassword() throws Exception {
        assertEquals("password1", myFirstUser.getPassword());
    }

    @Test
    public void testUserHasCorrectName() throws Exception {
        assertEquals("User One", myFirstUser.getName());
    }

    @Test
    public void testUserHasCorrectEmail() throws Exception {
        assertEquals("Email", myFirstUser.getEmail());
    }

    @Test
    public void testUserHasCorrectPhoneNumber() throws Exception {
        assertEquals("Phone", myFirstUser.getPhoneNumber());
    }

    @Test
    public void shouldAddBookToListWhenBookCheckedOut() throws Exception {
        Book mockBook = mock(Book.class);
        myFirstUser.addBook(mockBook);
        assertEquals(myFirstUser.getBooksCheckedOut().size(), 1);
    }

    @Test
    public void shouldRemoveBookFromListWhenBookCheckedIn() throws Exception {
        Book mockBook = mock(Book.class);
        myFirstUser.addBook(mockBook);
        myFirstUser.removeBook(mockBook);
        assertEquals(myFirstUser.getBooksCheckedOut().size(), 0);
    }

    @Test
    public void shouldAddMovieToListWhenMovieCheckedOut() throws Exception {
        Movie mockMovie = mock(Movie.class);
        myFirstUser.addMovie(mockMovie);
        assertEquals(myFirstUser.getMoviesCheckedOut().size(), 1);
    }

    @Test
    public void shouldRemoveMovieFromListWhenMovieCheckedIn() throws Exception {
        Movie mockMovie = mock(Movie.class);
        myFirstUser.addMovie(mockMovie);
        myFirstUser.removeMovie(mockMovie);
        assertEquals(myFirstUser.getMoviesCheckedOut().size(), 0);
    }
}
