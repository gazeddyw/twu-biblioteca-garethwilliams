package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String checkOut() {
        if (isCheckedOut()) {
            return "That book is currently checked out.";
        } else {
            checkedOut = true;
            return "Thank you! Enjoy the book.";
        }
    }

    public String checkIn() {
        if (isCheckedOut()) {
            checkedOut = false;
            return "Thank you for returning the book.";
        } else {
            return "That book is not currently checked out.";
        }
    }
}
