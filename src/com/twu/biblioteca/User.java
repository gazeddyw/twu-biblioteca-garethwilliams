package com.twu.biblioteca;

/**
 * Created by Gareth Williams on 2/23/15.
 */
public class User {

    private String libraryNumber;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
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
}
