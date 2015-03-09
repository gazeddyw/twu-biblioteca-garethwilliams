package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().init();
    }

    public void init() {
        LibraryLists libraryLists = new LibraryLists();
        Validator validator = new Validator(libraryLists);
        Library library = new Library(libraryLists, validator);
        Scanner scanner = new Scanner(System.in);

        Driver d = new Driver(libraryLists, validator, library, scanner);
        d.run();
    }
}
