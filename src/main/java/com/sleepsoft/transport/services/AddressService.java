package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.AddressDao;
import com.sleepsoft.transport.pojos.AddressesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("addressService")
public class AddressService {
    final
    AddressDao addressDao;

    @Autowired
    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<AddressesPOJO> createAddress(AddressesPOJO address){
        return Optional.ofNullable(addressDao.save(address));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> findById(String addressId){
        return Optional.ofNullable(addressDao.findOne(addressId));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> findOneByCriteria (AddressesPOJO addressesPOJO){
        Example<AddressesPOJO> example = Example.of(addressesPOJO);
        return Optional.ofNullable(addressDao.findOne(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<AddressesPOJO>> findAllByCriteria (AddressesPOJO addressesPOJO){
        Example<AddressesPOJO> example = Example.of(addressesPOJO);
        return Optional.ofNullable(addressDao.findAll(example));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> updateAddress(String id, AddressesPOJO address){
        AddressesPOJO oldAddress= addressDao.findOne(id);
        if (oldAddress==null) return Optional.empty();
        oldAddress.setState(address.getState()!=null?address.getState():oldAddress.getState());
        oldAddress.setStreet(address.getStreet()!=null?address.getStreet():oldAddress.getStreet());
        oldAddress.setStreet2(address.getStreet2()!=null?address.getStreet2():oldAddress.getStreet2());
        oldAddress.setZipCode(address.getZipCode()!=null?address.getZipCode():oldAddress.getZipCode());
        return Optional.ofNullable(addressDao.save(oldAddress));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void deleteAddress(String id){
        addressDao.delete(id);
    }


}
