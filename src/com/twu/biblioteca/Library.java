package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private User currentUser;

    private static LibraryLists libraryLists;
    private Validator validator;

    public Library(LibraryLists libraryLists, Validator validator) {
        this.libraryLists = libraryLists;
        this.validator = validator;
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String validateAndCheckOutBook(String title) {
        Book book;
        try {
            book = validator.findBookByTitle(title);
        } catch (NoSuchElementException nsee) {
            return "That book is not available.";
        }
        if (book.getTitle().equalsIgnoreCase(title) &&
                !book.isCheckedOut()) {
            getCurrentUser().addBook(book);
        }
        return book.checkOut();
    }

    public String validateAndCheckOutMovie(String title) {
        for (Movie movie : libraryLists.getMovies()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                if (!movie.isCheckedOut()) {
                    getCurrentUser().addMovie(movie);
                }
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public String validateAndCheckInBook(String title) {
        for (Book book : libraryLists.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (getCurrentUser().isBookHeldByUser(book)) {
                    getCurrentUser().removeBook(book);
                    return book.checkIn();
                }
            }
        }
        return "That is not a valid book to return.";
    }

    public String validateAndCheckInMovie(String title) {
        for (Movie movie : libraryLists.getMovies()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                if (getCurrentUser().isMovieHeldByUser(movie)) {
                    getCurrentUser().removeMovie(movie);
                    return movie.checkIn();
                }
            }
        }
        return "That is not a valid movie to return.";
    }
}
