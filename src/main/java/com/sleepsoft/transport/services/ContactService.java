package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.ContactsDao;
import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("contactService")
public class ContactService {
    @Autowired
    ContactsDao contactsDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<ContactsPOJO> createContact(ContactsPOJO contact){
        Optional<ContactsPOJO> searchContact = findOneByCriteria(contact);
        if (searchContact.isPresent()) {
            return searchContact;
        }
        else {
            return Optional.of(contactsDao.save(contact));
        }
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<ContactsPOJO> findOneByCriteria(ContactsPOJO contact) {
        Example<ContactsPOJO> example = Example.of(contact);
        return Optional.of(contactsDao.findOne(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<ContactsPOJO>> findAllByCriteria(ContactsPOJO contact){
        Example<ContactsPOJO> example = Example.of(contact);
        return Optional.of(contactsDao.findAll(example));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<ContactsPOJO> findById(String contactId){
        return Optional.of(contactsDao.findOne(contactId));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<ContactsPOJO> updateContact(String id, ContactsPOJO contact){
        ContactsPOJO originalContact = contactsDao.findOne(id);
        if (originalContact==null) return Optional.empty();
        originalContact.setContact(contact.getContact()!=null?contact.getContact():originalContact.getContact());
        originalContact.setContactType(contact.getContactType()!=null?contact.getContactType():originalContact.getContactType());
        return Optional.of(contactsDao.save(originalContact));
    }
}
