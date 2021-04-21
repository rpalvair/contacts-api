package com.palvair.contacts.presentation;

import com.palvair.contacts.application.CreateContactCommand;
import com.palvair.contacts.domain.Contact;
import com.palvair.contacts.domain.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CreateContactResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateContactResource.class);

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contacts/create-contact")
    public Contact createContact(@RequestBody CreateContactCommand command) {
        LOGGER.info("Command to create a contact {}", command);
        final Contact contact = contactRepository.save(new Contact(command.getFirstName(), command.getLastName(), command.getAge()));
        LOGGER.info("Contact {} created", contact);
        return contact;
    }
}
