package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by Gareth Williams on 2/18/15.
 */
public class Menu {

    public static void createMenu() {
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
        } while (menuChoice != 2);
        printGoodbyeMessage();
    }

    private static void printGoodbyeMessage() {
        System.out.println("Goodbye, thanks for using Biblioteca.\n");
    }

    public static void printWelcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    public static void printMenu() {
        System.out.println("\t1 - List Library Books");
        System.out.println("\t2 - Quit");
        System.out.println();
    }

    public static void printMenuPrompt() {
        System.out.println("Please enter option:");
    }

    private static void printInvalidMenuOptionMessage() {
        System.out.println("Select a valid option!\n");
    }
}
