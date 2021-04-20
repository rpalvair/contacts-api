package com.palvair.contacts.application;

import com.palvair.contacts.application.exceptions.ContactNotFoundException;
import com.palvair.contacts.domain.Contact;
import com.palvair.contacts.domain.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;
    @Mock
    private ContactRepository contactRepository;

    @Test
    public void should_throw_exception_when_contact_doesnt_exist() {
        assertThatThrownBy(() -> contactService.updateContact(new UpdateContactCommand())).isInstanceOf(ContactNotFoundException.class);
    }

    @Test
    public void should_update_contact_when_contact_exists() {
        final UpdateContactCommand command = new UpdateContactCommand();
        command.setId("1");
        command.setFirstName("Jean");
        command.setLastName("Dupond");
        command.setAge(42L);
        final Contact jeanDupond = new Contact("Jean", "Dupond", 42L, "1");

        when(contactRepository.findById("1")).thenReturn(Optional.of(new Contact("Ruddy", "Palvair", 35L)));
        when(contactRepository.save(jeanDupond)).thenReturn(jeanDupond);

        final Contact result = contactService.updateContact(command);

        assertThat(result).isNotNull()
                .extracting(Contact::getFirstName, Contact::getLastName, Contact::getAge, Contact::getId)
                .containsExactly("Jean", "Dupond", 42L, "1");
    }

}