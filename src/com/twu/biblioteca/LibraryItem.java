package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public abstract class LibraryItem {

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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public abstract String checkOut();

    public abstract String checkIn();
}
