package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.ContactsDao;
import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactService {
    @Autowired
    ContactsDao contactsDao;
    public ContactsPOJO createContact(ContactsPOJO contact){
        ContactsPOJO searchContact = contactsDao.findByContact(contact);
        if (searchContact!=null) {
            return searchContact;
        }
        else {
            return contactsDao.save(contact);
        }
    }

    public ContactsPOJO getContact(String contactId){
        return contactsDao.findOne(contactId);
    }

    public List<ContactsPOJO> getList(ContactsPOJO proxy){
        return null;
    }
}
