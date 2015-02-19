package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Driver {

    public void run() {
        printWelcomeMessage();

        int menuChoice = 0;
        do {
            printMenu();
            printMenuPrompt();
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            try {
                menuChoice = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                printInvalidMenuOptionMessage();
            }
            if (menuChoice < 1 || menuChoice > 2) {
                printInvalidMenuOptionMessage();
            }
            if (menuChoice == 1) {
                printBookList();
            }
        } while (menuChoice != 2);
        printGoodbyeMessage();
    }

    private void printBookList() {
        printBookListHeader();
        for (Book book : Library.getLibraryBookList()) {
            System.out.println("\t" + book.getTitle() + "\t\t\t" +
                    book.getAuthor() + "\t\t\t" + book.getYearPublished());
        }
    }

    private void printBookListHeader() {
        System.out.println("Currently available books:\n");
        System.out.println("\tTitle\t\t\tAuthor\t\t\tYear Published");
        System.out.println("\t-----\t\t\t------\t\t\t--------------");
    }

    private void printGoodbyeMessage() {
        System.out.println("Goodbye, thanks for using Biblioteca.\n");
    }

    private void printWelcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    private void printMenu() {
        System.out.println("\t1 - List Library Books");
        System.out.println("\t2 - Quit");
        System.out.println();
    }

    private void printMenuPrompt() {
        System.out.println("Please enter option:");
    }

    private void printInvalidMenuOptionMessage() {
        System.out.println("Select a valid option!\n");
    }
}
