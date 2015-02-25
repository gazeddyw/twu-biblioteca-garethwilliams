package com.twu.biblioteca;

import java.util.List;

/**
 * Created by Gareth Williams on 2/24/15.
 */
public interface LibraryListsInterface {
    void initialiseLibraryBookList();

    void initialiseLibraryMovieList();

    void initialiseLibraryUserList();

    List<Book> getBooks();

    List<Movie> getMovies();

    List<User> getUsers();
}
