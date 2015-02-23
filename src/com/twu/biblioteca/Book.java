package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Book extends LibraryItem {

    private String author;

    public Book(String title, String author, int yearPublished) {
        super(title, yearPublished);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
