package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private User currentUser;

    private static LibraryLists libraryLists;

    public Library(LibraryLists libraryLists) {
        this.libraryLists = libraryLists;
        currentUser = null;
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String validateAndCheckOutBook(String title) {
        for (Book book : getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    getCurrentUser().addBook(book);
                }
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public String validateAndCheckOutMovie(String title) {
        for (Movie movie : getLibraryMovieList()) {
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
        for (Book book : getLibraryBookList()) {
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
        for (Movie movie : getLibraryMovieList()) {
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
