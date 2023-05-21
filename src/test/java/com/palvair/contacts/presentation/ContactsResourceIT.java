package com.palvair.contacts.presentation;

import com.palvair.contacts.infrastructure.spring.ApplicationConfiguration;
import com.palvair.contacts.presentation.errors.ContactsError;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ApplicationConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactsResourceIT {

    private static final Logger logger = LoggerFactory.getLogger(ContactsResourceIT.class);

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void should_return_error_with_status_404_when_contact_not_found() {
        final ResponseEntity<ContactsError> entity = testRestTemplate.getForEntity("/contacts/42", ContactsError.class);

        assertThat(entity).isNotNull()
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.NOT_FOUND);

        logger.debug("entity {}", entity);

        final ContactsError body = entity.getBody();
        assertThat(body).isNotNull()
                .extracting(ContactsError::getMessage)
                .isEqualTo("Contact not found with id 42");
    }
}