package com.example.ZeroneMailingMicroservice.exception;

public class EmailNotSentException extends Exception {
    public EmailNotSentException(String message) {
        super(message);
    }
}
