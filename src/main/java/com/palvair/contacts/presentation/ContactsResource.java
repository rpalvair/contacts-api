package com.palvair.contacts.presentation;

import com.palvair.contacts.application.exceptions.ContactNotFoundException;
import com.palvair.contacts.domain.Contact;
import com.palvair.contacts.domain.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ContactsResource {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> all() {
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Contact getOne(@PathVariable String id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(String.format("Contact not found with id %s", id)));
    }
}
