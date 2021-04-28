package com.palvair.contacts.application.exceptions;

public abstract class ContactApiException extends RuntimeException {

    public ContactApiException(final String message) {
        super(message);
    }
}
