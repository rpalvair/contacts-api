package com.palvair.contacts.application.exceptions;

public class ContactNotFoundException extends ContactApiException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
