package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.ContactsDao;
import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactService {
    @Autowired
    ContactsDao contactsDao;
    public ContactsPOJO createContact(ContactsPOJO contact){
        ContactsPOJO searchContact = findByContact(contact);
        if (searchContact!=null) {
            return searchContact;
        }
        else {
            return contactsDao.save(contact);
        }
    }

    public ContactsPOJO findByContact(ContactsPOJO contact) {
        Example<ContactsPOJO> example = Example.of(contact);
        return contactsDao.findOne(example);
    }

    public Iterable<ContactsPOJO> findContactsByCriteria(ContactsPOJO contact){
        Example<ContactsPOJO> example=Example.of(contact);
        return contactsDao.findAll(example);
    }

    public ContactsPOJO getContact(String contactId){
        return contactsDao.findOne(contactId);
    }

    public List<ContactsPOJO> getList(ContactsPOJO proxy){
        return null;
    }

    public ContactsPOJO updateContact(String id, ContactsPOJO contact){
        ContactsPOJO originalContact = contactsDao.findOne(id);
        originalContact.setContact(contact.getContact()!=null?contact.getContact():originalContact.getContact());
        originalContact.setContactType(contact.getContactType()!=null?contact.getContactType():originalContact.getContactType());
        return contactsDao.save(originalContact);
    }
}
