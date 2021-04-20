package com.palvair.contacts.domain;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ContactRepository extends MongoRepository<Contact, String> {
}
