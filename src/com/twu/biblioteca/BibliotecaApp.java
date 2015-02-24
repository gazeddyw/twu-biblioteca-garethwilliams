package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().init();
    }

    private void init() {
        Library lib = new Library();
        lib.initialiseLibraryBookList();
        lib.initialiseLibraryMovieList();
        lib.initialiseLibraryUserList();

        Driver d = new Driver();
        d.run();
    }
}
