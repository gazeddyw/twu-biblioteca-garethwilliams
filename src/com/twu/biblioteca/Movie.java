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

    public String checkOut() {
        if (isCheckedOut()) {
            return "That movie is currently checked out.";
        } else {
            checkedOut = true;
            return "Thank you! Enjoy the movie.";
        }
    }

    public String checkIn() {
        if (isCheckedOut()) {
            checkedOut = false;
            return "Thank you for returning the movie.";
        } else {
            return "That movie is not currently checked out.";
        }
    }
}
