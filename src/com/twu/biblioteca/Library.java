package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private List<Book> libraryBookList;

    public Library() {
        libraryBookList = new ArrayList<Book>();
    }

    public List<Book> getLibraryBookList() {
        return libraryBookList;
    }
}
