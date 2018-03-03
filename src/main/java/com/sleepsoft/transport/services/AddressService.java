package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.AddressDao;
import com.sleepsoft.transport.pojos.AddressesPOJO;
import com.sleepsoft.transport.util.FilterHelper;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("addressService")
public class AddressService {
    @Autowired
    AddressDao addressDao;
    FilterHelper filterHelper = new FilterHelper<AddressesPOJO>(AddressesPOJO.class);

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<AddressesPOJO> createAddress(AddressesPOJO address){
        return Optional.of(addressDao.save(address));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> findById(String addressId){
        return Optional.of(addressDao.findOne(addressId));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> findOneByCriteria (AddressesPOJO addressesPOJO){
        Example<AddressesPOJO> example = Example.of(addressesPOJO);
        return Optional.of(addressDao.findOne(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<AddressesPOJO>> findAllByCriteria (AddressesPOJO addressesPOJO){
        Example<AddressesPOJO> example = Example.of(addressesPOJO);
        return Optional.of(addressDao.findAll(example));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<AddressesPOJO> updateAddress(String id, AddressesPOJO address){
        AddressesPOJO oldAddress= addressDao.findOne(id);
        if (oldAddress==null) return null;
        oldAddress.setState(address.getState()!=null?address.getState():oldAddress.getState());
        oldAddress.setStreet(address.getStreet()!=null?address.getStreet():oldAddress.getStreet());
        oldAddress.setStreet2(address.getStreet2()!=null?address.getStreet2():oldAddress.getStreet2());
        oldAddress.setZipCode(address.getZipCode()!=null?address.getZipCode():oldAddress.getZipCode());
        return Optional.of(addressDao.save(oldAddress));
    }

    @Transactional(readOnly = false, propagation=Propagation.REQUIRED)
    public void deleteAddress(String id){
        addressDao.delete(id);
    }


}
