package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().init();
    }

    private void init() {
        Driver d = new Driver();
        d.run();
    }
}
