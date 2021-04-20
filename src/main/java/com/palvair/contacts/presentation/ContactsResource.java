package com.palvair.contacts.presentation;

import com.palvair.contacts.domain.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ContactsResource {

    @GetMapping("/contacts")
    public List<Contact> all() {
        return Collections.emptyList();
    }
}
