package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class LibraryItem {

    protected String title;
    protected boolean checkedOut;
    protected int yearPublished;

    public LibraryItem(String title, int yearPublished) {
        this.checkedOut = false;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String checkOut() {
        if (isCheckedOut()) {
            return "That " + itemType() + " is currently checked out.";
        } else {
            checkedOut = true;
            return "Thank you! Enjoy the " + itemType() + ".";
        }
    }

    public String checkIn() {
        if (isCheckedOut()) {
            checkedOut = false;
            return "Thank you for returning the " + itemType() + ".";
        } else {
            return "That " + itemType() + " is not currently checked out.";
        }
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    private String itemType() {
        if (this instanceof Book) {
            return "book";
        }
        else if (this instanceof Movie) {
            return "movie";
        }
        else {
            return "item";
        }
    }
}
