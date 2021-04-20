package com.palvair.contacts.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {

    private String id;
    private final String firstName;
    private final String lastName;
    private final Long age;

    public Contact(String firstName, String lastName, Long age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getAge() {
        return age;
    }
}
