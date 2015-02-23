package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Library {

    private static List<Book> libraryBookList;

    private static List<Movie> libraryMovieList;

    public Library() {
        libraryBookList = new ArrayList<Book>();
        libraryMovieList = new ArrayList<Movie>();
    }

    public static List<Book> getLibraryBookList() {
        return libraryBookList;
    }

    public static List<Movie> getLibraryMovieList() {
        return libraryMovieList;
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

    public static String validateBookForCheckOut(String title) {
        for (int index = 0; index < getLibraryBookList().size(); index++) {
            Book book = getLibraryBookList().get(index);
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkOut();
            }
        }
        return "That book is not available.";
    }

    public static String validateMovieForCheckOut(String title) {
        for (int index = 0; index < getLibraryBookList().size(); index++) {
            Movie movie = getLibraryMovieList().get(index);
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie.checkOut();
            }
        }
        return "That movie is not available.";
    }

    public static String validateBookForCheckIn(String title) {
        for (int index = 0; index < getLibraryBookList().size(); index++) {
            Book book = getLibraryBookList().get(index);
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.checkIn();
            }
        }
        return "That is not a valid book to return.";
    }
}
