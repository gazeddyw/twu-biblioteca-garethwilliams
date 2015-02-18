package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class BookTest {

    private Book myFirstBook;

    @Before
    public void setUp() throws Exception {
        myFirstBook = new Book("Title", "Author", 2015, false);
    }

    @Test
    public void testBookCreatedHasFieldsSetCorrectly() {
        assertEquals(myFirstBook.getTitle(), "Title");
        assertEquals(myFirstBook.getAuthor(), "Author");
        assertEquals(myFirstBook.getYearPublished(), 2015);
        assertEquals(myFirstBook.isCheckedOut(), false);
    }

    @Test
    public void testInvalidMenuOptionReturnsCorrectString() {
    }
}
