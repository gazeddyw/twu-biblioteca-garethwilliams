package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> booksCheckedOut;
    private List<Movie> moviesCheckedOut;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        booksCheckedOut = new ArrayList<Book>();
        moviesCheckedOut = new ArrayList<Movie>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public List<Movie> getMoviesCheckedOut() {
        return moviesCheckedOut;
    }

    public void addBook(Book book) {
        getBooksCheckedOut().add(book);
    }

    public void removeBook(Book book) {
        getBooksCheckedOut().remove(book);
    }

    public boolean isBookHeldByUser(Book book) {
        return getBooksCheckedOut().contains(book);
    }

    public void addMovie(Movie movie) {
        getMoviesCheckedOut().add(movie);
    }

    public void removeMovie(Movie movie) {
        getMoviesCheckedOut().remove(movie);
    }

    public boolean isMovieHeldByUser(Movie movie) {
        return getMoviesCheckedOut().contains(movie);
    }
}
