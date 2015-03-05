package com.twu.biblioteca;

import java.util.NoSuchElementException;

/**
 * Created by Gareth Williams on 05/03/15.
 */
public class Validator {

    public boolean validateLibraryNumber(String libNumber) {
        for (User user : Library.getLibraryUserList()) {
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return true;
            }
        }
        return false;
    }

    public User findUserByLibraryNumber(String libNumber) {
        for (User user : Library.getLibraryUserList()) {
            if (user.getLibraryNumber().equalsIgnoreCase(libNumber)) {
                return user;
            }
        }
        return null;
    }

    public boolean validateUserCredentials(User user, String password) {
        return user.getPassword().equals(password);
    }

    public Book findBookByTitle(String title) throws NoSuchElementException {
        for (Book book : Library.getLibraryBookList()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new NoSuchElementException();
    }
}
