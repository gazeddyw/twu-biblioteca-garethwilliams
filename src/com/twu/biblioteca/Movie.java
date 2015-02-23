package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class Movie extends LibraryItem {

    private String director;
    private int rating;

    public Movie(String title, int yearPublished, String director, int rating) {
        super(title, yearPublished);
        this.director = director;
        this.rating = rating;
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
}
