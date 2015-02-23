package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class MovieTest {

    private Movie myFirstMovie;

    @Before
    public void setUp() throws Exception {
        myFirstMovie = new Movie("Title", 2015, "Director", 10);
    }

    @Test
    public void testMovieCreatedHasFieldsSetCorrectly() {
        assertEquals(myFirstMovie.getTitle(), "Title");
        assertEquals(myFirstMovie.getYearPublished(), 2015);
        assertEquals(myFirstMovie.getDirector(), "Director");
        assertEquals(myFirstMovie.getRating(), 10);
        assertFalse(myFirstMovie.isCheckedOut());
    }

    @Test
    public void testCheckOutMovie() {
        assertEquals("Thank you! Enjoy the movie.", myFirstMovie.checkOut());
        assertEquals(true, myFirstMovie.isCheckedOut());
    }

    @Test
    public void testCheckInMovie() throws Exception {
        myFirstMovie.checkOut();
        assertEquals("Thank you for returning the movie.", myFirstMovie.checkIn());
        assertEquals(false, myFirstMovie.isCheckedOut());
    }
}
