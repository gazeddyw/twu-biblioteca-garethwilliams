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
        return user.getPassword().equals(password);
    }

    public String validateAndCheckOutBook(String title) {
        User currentUser = Driver.getCurrentUser();
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    currentUser.addBook(book);
                }
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public String validateAndCheckOutMovie(String title) {
        User currentUser = Driver.getCurrentUser();
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                if (!movie.isCheckedOut()) {
                    currentUser.addMovie(movie);
                }
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public String validateAndCheckInBook(String title) {
        User currentUser = Driver.getCurrentUser();
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (currentUser.isBookHeldByUser(book)) {
                    currentUser.removeBook(book);
                    return book.checkIn();
                }
            }
        }
        return "That is not a valid book to return.";
    }

    public String validateAndCheckInMovie(String title) {
        User currentUser = Driver.getCurrentUser();
        for (Movie movie : getLibraryMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                if (currentUser.isMovieHeldByUser(movie)) {
                    currentUser.removeMovie(movie);
                    return movie.checkIn();
                }
            }
        }
        return "That is not a valid movie to return.";
    }
}
