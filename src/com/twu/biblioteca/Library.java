package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private static List<Book> libraryBookList;
    private static List<Movie> libraryMovieList;
    private static List<User> libraryUserList;

    public Library() {
        libraryBookList = new ArrayList<Book>();
        libraryMovieList = new ArrayList<Movie>();
        libraryUserList = new ArrayList<User>();
    }

    public static List<Book> getLibraryBookList() {
        return libraryBookList;
    }

    public static List<Movie> getLibraryMovieList() {
        return libraryMovieList;
    }

    public static List<User> getLibraryUserList() {
        return libraryUserList;
    }

    public void initialiseLibraryBookList() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + i, "Author " + i, i + 2000);
            libraryBookList.add(book);
        }
    }

    public void initialiseLibraryMovieList() {
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie("Movie " + i, i + 2000, "Director " + i, i + 1);
            libraryMovieList.add(movie);
        }
    }

    public void initialiseLibraryUserList() {
        User user = new User("123-4567", "password0",
                "Test User 0", "test0@test.com", "01234012340");
        libraryUserList.add(user);
        user = new User("234-5678", "password1",
                "Test User 1", "test1@test.com", "06789567890");
        libraryUserList.add(user);
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
        for (int index = 0; index < getLibraryBookList().size(); index++) {
            Book book = getLibraryBookList().get(index);
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public static String validateAndCheckOutMovie(String title) {
        for (int index = 0; index < getLibraryMovieList().size(); index++) {
            Movie movie = getLibraryMovieList().get(index);
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public static String validateAndCheckInBook(String title) {
        for (int index = 0; index < getLibraryBookList().size(); index++) {
            Book book = getLibraryBookList().get(index);
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkIn();
            }
        }
        return "That is not a valid book to return.";
    }

    public static String validateAndCheckInMovie(String title) {
        for (int index = 0; index < getLibraryMovieList().size(); index++) {
            Movie movie = getLibraryMovieList().get(index);
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkIn();
            }
        }
        return "That is not a valid movie to return.";
    }
}
