package com.palvair.contacts.presentation;

import com.palvair.contacts.application.ContactService;
import com.palvair.contacts.application.UpdateContactCommand;
import com.palvair.contacts.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateContactResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateContactResource.class);

    @Autowired
    private ContactService contactService;

    @PutMapping("/update-contact")
    public Contact updateContact(@RequestBody UpdateContactCommand command) {
        LOGGER.info("Command for updating contact {}", command);
        return contactService.updateContact(command);
    }
}
