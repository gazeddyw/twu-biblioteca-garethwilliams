package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class Movie {

    private String title;
    private int yearPublished;
    private String director;
    private int rating;
    private boolean checkedOut;

    public Movie(String title, int yearPublished, String director, int rating) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.director = director;
        this.rating = rating;
        this.checkedOut = false;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
