package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private static LibraryLists libraryLists;

    public Library(LibraryLists libraryLists) {
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

    public static boolean validateLibraryNumber(String libNumber) {
        for (int index = 0; index < getLibraryUserList().size(); index++) {
            User user = getLibraryUserList().get(index);
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return true;
            }
        }
        return false;
    }

    public static User findUserByLibraryNumber(String libNumber) {
        for (int index = 0; index < getLibraryUserList().size(); index++) {
            User user = getLibraryUserList().get(index);
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return user;
            }
        }
        return null;
    }

    public static boolean validateUserCredentials(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static String validateAndCheckOutBook(String title) {
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public static String validateAndCheckOutMovie(String title) {
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public static String validateAndCheckInBook(String title) {
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkIn();
            }
        }
        return "That is not a valid book to return.";
    }

    public static String validateAndCheckInMovie(String title) {
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkIn();
            }
        }
        return "That is not a valid movie to return.";
    }
}
