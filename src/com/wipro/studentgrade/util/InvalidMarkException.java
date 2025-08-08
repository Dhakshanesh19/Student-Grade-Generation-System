package com.wipro.studentgrade.util;

public class InvalidMarkException extends Exception {
    private String message;

    public InvalidMarkException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvalidMarkException: " + message;
    }
}