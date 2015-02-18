package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void listBooksTest() {
    }

    @Test
    public void testBookCreation() {
        Book myBook = new Book("Title", "Author", 2015);
        assertEquals(myBook.getTitle(), "Title");
        assertEquals(myBook.getAuthor(), "Author");
        assertEquals(myBook.getYearPublished(), 2015);
    }

    @Test
    public void testBookHasAuthor() {
    }

    @Test
    public void testBookHasYearPublished () {
    }

    @Test
    public void testInvalidMenuOptionReturnsCorrectString() {
    }

    @Test
    public void testCheckoutBookDecrementsBookList() {
    }

    @Test
    public void testCheckinBookIncrementsBookList() {
    }
}
