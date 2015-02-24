package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/24/15.
 */
public class LibraryLists {

    private static List<Book> libraryBookList;
    private static List<Movie> libraryMovieList;
    private static List<User> libraryUserList;

    public LibraryLists() {
        initialiseLibraryBookList();
        initialiseLibraryMovieList();
        initialiseLibraryUserList();
    }

    public void initialiseLibraryBookList() {
        libraryBookList = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + i, "Author " + i, i + 2000);
            libraryBookList.add(book);
        }
    }

    public void initialiseLibraryMovieList() {
        libraryMovieList = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie("Movie " + i, i + 2000, "Director " + i, i + 1);
            libraryMovieList.add(movie);
        }
    }

    public void initialiseLibraryUserList() {
        libraryUserList = new ArrayList<User>();
        User user = new User("123-4567", "password0",
                "Test User 0", "test0@test.com", "01234012340");
        libraryUserList.add(user);
        user = new User("234-5678", "password1",
                "Test User 1", "test1@test.com", "06789567890");
        libraryUserList.add(user);
    }

    public List<Book> getBooks() {
        return libraryBookList;
    }

    public List<Movie> getMovies() {
        return libraryMovieList;
    }

    public List<User> getUsers() {
        return libraryUserList;
    }
}
