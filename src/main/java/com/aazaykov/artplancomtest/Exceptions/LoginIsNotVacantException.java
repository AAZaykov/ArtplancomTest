package com.aazaykov.artplancomtest.Exceptions;

public class LoginIsNotVacantException extends RuntimeException {
    public LoginIsNotVacantException(String message) {
        super(message);
    }
}