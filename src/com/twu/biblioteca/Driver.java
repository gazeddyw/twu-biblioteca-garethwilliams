package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Driver {

    private static final int MIN_MENU_CHOICE = 1;
    private static final int MAX_MENU_CHOICE = 5;
    private static final int MAX_LOANS_MENU_CHOICE = 3;

    Scanner scanner;

    public void run() {
        printWelcomeMessage();
        scanner = new Scanner(System.in);

        int menuChoice = 0;
        do {
            printMenu();
            printMenuPrompt();
            menuChoice = getUserMenuSelection(MIN_MENU_CHOICE, MAX_MENU_CHOICE);

            if (menuChoice == 1) {
                printBookList();
            }
            if (menuChoice == 2) {
                printMovieList();
            }
            if (menuChoice == 3) {
                handleCheckOut();
            }
            if (menuChoice == 4) {
                handleCheckIn();
            }
        } while (menuChoice != MAX_MENU_CHOICE);

        printGoodbyeMessage();
    }

    private int getUserMenuSelection(int minMenuChoice, int maxMenuChoice) {
        String input = scanner.nextLine();
        int result = 0;
        try {
            result = Integer.parseInt(input);
            if (result < minMenuChoice || result > maxMenuChoice) {
                printInvalidMenuOptionMessage();
            }
        } catch (NumberFormatException nfe) {
            printInvalidMenuOptionMessage();
        }
        return result;
    }

    private void handleCheckOut() {
        int loansMenuChoice = 0;
        do {
            printLoansMenu();
            printMenuPrompt();
            loansMenuChoice = getUserMenuSelection(MIN_MENU_CHOICE, MAX_LOANS_MENU_CHOICE);
            if (loansMenuChoice == 1) {
                showCheckOutBookPrompt();
            }
            if (loansMenuChoice == 2) {
                showCheckOutMoviePrompt();
            }
        } while (loansMenuChoice != MAX_LOANS_MENU_CHOICE);
    }

    private void handleCheckIn() {
        int loansMenuChoice = 0;
        do {
            printLoansMenu();
            printMenuPrompt();
            loansMenuChoice = getUserMenuSelection(MIN_MENU_CHOICE, MAX_LOANS_MENU_CHOICE);
            if (loansMenuChoice == 1) {
                showCheckInBookPrompt();
            }
            if (loansMenuChoice == 2) {
                showCheckInMoviePrompt();
            }
        } while (loansMenuChoice != MAX_LOANS_MENU_CHOICE);
    }

    private void printLoansMenu() {
        System.out.println("Item type:\n");
        System.out.println("\t1 - Book");
        System.out.println("\t2 - Movie");
        System.out.println("\t3 - Main Menu");
        System.out.println();
    }

    private void showCheckOutBookPrompt() {
        System.out.println("Enter title of book to check out:");
        String input = scanner.nextLine();
        String message = Library.validateAndCheckOutBook(input);
        System.out.println(message + "\n");
    }

    private void showCheckOutMoviePrompt() {
        System.out.println("Enter title of movie to check out:");
        String input = scanner.nextLine();
        String message = Library.validateAndCheckOutMovie(input);
        System.out.println(message + "\n");
    }

    private void showCheckInBookPrompt() {
        System.out.println("Enter title of book to check in:");
        String input = scanner.nextLine();
        String message = Library.validateAndCheckInBook(input);
        System.out.println(message + "\n");
    }

    private void showCheckInMoviePrompt() {
        System.out.println("Enter title of movie to check out:");
        String input = scanner.nextLine();
        String message = Library.validateAndCheckInMovie(input);
        System.out.println(message + "\n");
    }

    private void printBookList() {
        printBookListHeader();
        for (Book book : Library.getLibraryBookList()) {
            if (!book.isCheckedOut()) {
                System.out.println("\t" + book.getTitle() + "\t\t\t" +
                        book.getAuthor() + "\t\t\t" + book.getYearPublished());
            }
        }
        System.out.println("\n");
    }

    private void printMovieList() {
        printMovieListHeader();
        for (Movie movie : Library.getLibraryMovieList()) {
            if (!movie.isCheckedOut()) {
                System.out.println("\t" + movie.getTitle() + "\t\t\t" +
                        movie.getDirector() + "\t\t\t" + movie.getYearPublished() +
                        "\t\t\t\t\t" + movie.getRating());
            }
        }
        System.out.println("\n");
    }

    private void printBookListHeader() {
        System.out.println("Currently available books:\n");
        System.out.println("\tTitle\t\t\tAuthor\t\t\t\tYear Published");
        System.out.println("\t-----\t\t\t------\t\t\t\t--------------");
    }

    private void printMovieListHeader() {
        System.out.println("Currently available movies:\n");
        System.out.println("\tTitle\t\t\tDirector\t\t\tYear Published\t\t\tRating");
        System.out.println("\t-----\t\t\t--------\t\t\t--------------\t\t\t------");
    }

    private void printGoodbyeMessage() {
        System.out.println("Goodbye, thanks for using Biblioteca.\n");
    }

    private void printWelcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    private void printMenu() {
        System.out.println("Options:\n");
        System.out.println("\t1 - List Library Books");
        System.out.println("\t2 - List Library Movies");
        System.out.println("\t3 - Check Out Item");
        System.out.println("\t4 - Check In Item");
        System.out.println("\t5 - Quit");
        System.out.println();
    }

    private void printMenuPrompt() {
        System.out.println("Please enter option:");
    }

    private void printInvalidMenuOptionMessage() {
        System.out.println("Select a valid option!\n");
    }
}
