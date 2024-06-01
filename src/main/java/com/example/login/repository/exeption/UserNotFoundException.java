package com.example.login.repository.exeption;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Incorrect username or password");
    }
}
