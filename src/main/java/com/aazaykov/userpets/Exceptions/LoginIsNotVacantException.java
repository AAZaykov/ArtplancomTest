package com.aazaykov.userpets.Exceptions;

public class LoginIsNotVacantException extends RuntimeException {
    public LoginIsNotVacantException(String message) {
        super(message);
    }
}