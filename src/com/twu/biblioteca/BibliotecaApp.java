package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        Menu.printWelcomeMessage();
        Menu.printMenu();
        Menu.printMenuPrompt();
    }
}
