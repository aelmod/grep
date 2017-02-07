package com.geekhub.scherbina.grep.exceptions;

public class BadPathException extends Exception {
    private String message;

    public BadPathException(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    @Override
    public String toString() {
        return message;
    }
}
