package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.data.repository.CrudRepository;

public interface ContactsDao extends CrudRepository<ContactsPOJO, String> {
    ContactsPOJO findByContact(ContactsPOJO contactsPOJO);
}
