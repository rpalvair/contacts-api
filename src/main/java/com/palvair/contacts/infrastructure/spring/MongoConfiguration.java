package com.palvair.contacts.infrastructure.spring;

import com.palvair.contacts.domain.Contact;
import com.palvair.contacts.domain.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.palvair.contacts"})
public class MongoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean
    public CommandLineRunner initDb(final ContactRepository contactRepository) {
        return args -> {
            LOGGER.info("initDb");
            contactRepository.deleteAll();
            final Contact contact = new Contact("Ruddy", "Palvair", 35L);
            contactRepository.save(contact);
        };
    }
}
