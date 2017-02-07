package com.geekhub.scherbina.grep.exceptions;

public class BadArgumentException extends Exception {
    private String message;

    public BadArgumentException(Throwable cause) {
        message = cause.getMessage();
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
