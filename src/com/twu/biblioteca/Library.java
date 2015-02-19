package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private static List<Book> libraryBookList;

    public Library() {
        libraryBookList = new ArrayList<Book>();
    }

    public static List<Book> getLibraryBookList() {
        return libraryBookList;
    }

    public void initialiseLibraryBookList() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Title " + i, "Author " + i, i + 2000);
            libraryBookList.add(book);
        }
    }

    public String validateBookForCheckIn(String title) {
        return "That is not a valid book to return.";
    }
}
