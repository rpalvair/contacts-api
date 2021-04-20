package com.palvair.contacts.presentation;

import com.palvair.contacts.application.DeleteContactCommand;
import com.palvair.contacts.domain.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteContactResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteContactResource.class);

    @Autowired
    private ContactRepository contactRepository;

    @DeleteMapping("/delete-contact")
    public void deleteContact(@RequestBody DeleteContactCommand command) {
        LOGGER.info("Command for deleting contact {}", command);
        LOGGER.info("Deleting contact {}", command.getId());
        contactRepository.deleteById(command.getId());
    }
}
