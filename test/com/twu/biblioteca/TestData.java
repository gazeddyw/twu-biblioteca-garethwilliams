package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 05/03/15.
 */
public class TestData {

    public static List<User> setupUsers() {
        List<User> userList = new ArrayList<User>();
        User user = new User("123-4567", "password0",
                "Test User 0", "test0@test.com", "01234012340");
        userList.add(user);
        user = new User("234-5678", "password1",
                "Test User 1", "test1@test.com", "06789567890");
        userList.add(user);
        return userList;
    }

    public static List<Book> setupBooks() {
        List<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + i, "Author " + i, i + 2000);
            bookList.add(book);
        }
        return bookList;
    }

    public static List<Movie> setupMovies() {
        List<Movie> movieList = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie("Movie " + i, i + 2000, "Director " + i, i + 1);
            movieList.add(movie);
        }
        return movieList;
    }
}
