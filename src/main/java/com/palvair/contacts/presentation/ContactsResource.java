package com.palvair.contacts.presentation;

import com.palvair.contacts.domain.Contact;
import com.palvair.contacts.domain.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class ContactsResource {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> all() {
        return contactRepository.findAll();
    }
}
