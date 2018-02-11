package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.ContactsDao;
import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactService")
public class ContactService {
    @Autowired
    ContactsDao contactsDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public ContactsPOJO createContact(ContactsPOJO contact){
        ContactsPOJO searchContact = findOneByCriteria(contact);
        if (searchContact!=null) {
            return searchContact;
        }
        else {
            return contactsDao.save(contact);
        }
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public ContactsPOJO findOneByCriteria(ContactsPOJO contact) {
        Example<ContactsPOJO> example = Example.of(contact);
        return contactsDao.findOne(example);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Iterable<ContactsPOJO> findAllByCriteria(ContactsPOJO contact){
        Example<ContactsPOJO> example=Example.of(contact);
        return contactsDao.findAll(example);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public ContactsPOJO findById(String contactId){
        return contactsDao.findOne(contactId);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public ContactsPOJO updateContact(String id, ContactsPOJO contact){
        ContactsPOJO originalContact = contactsDao.findOne(id);
        originalContact.setContact(contact.getContact()!=null?contact.getContact():originalContact.getContact());
        originalContact.setContactType(contact.getContactType()!=null?contact.getContactType():originalContact.getContactType());
        return contactsDao.save(originalContact);
    }
}
