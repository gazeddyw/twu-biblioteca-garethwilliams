package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private static LibraryListsInterface libraryLists;

    public Library(LibraryListsInterface libraryLists) {
        this.libraryLists = libraryLists;
    }

    public static List<Book> getLibraryBookList() {
        return libraryLists.getBooks();
    }

    public static List<Movie> getLibraryMovieList() {
        return libraryLists.getMovies();
    }

    public static List<User> getLibraryUserList() {
        return libraryLists.getUsers();
    }

    public boolean validateLibraryNumber(String libNumber) {
        for (User user : getLibraryUserList()) {
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return true;
            }
        }
        return false;
    }

    public User findUserByLibraryNumber(String libNumber) {
        for (User user : getLibraryUserList()) {
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return user;
            }
        }
        return null;
    }

    public boolean validateUserCredentials(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String validateAndCheckOutBook(String title) {
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public String validateAndCheckOutMovie(String title) {
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public String validateAndCheckInBook(String title) {
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkIn();
            }
        }
        return "That is not a valid book to return.";
    }

    public String validateAndCheckInMovie(String title) {
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkIn();
            }
        }
        return "That is not a valid movie to return.";
    }
}
