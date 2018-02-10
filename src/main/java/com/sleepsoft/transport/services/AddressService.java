package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.AddressDao;
import com.sleepsoft.transport.pojos.AddressesPOJO;
import com.sleepsoft.transport.util.FilterHelper;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressService {
    @Autowired
    AddressDao addressDao;
    FilterHelper filterHelper = new FilterHelper<AddressesPOJO>(AddressesPOJO.class);

    public AddressesPOJO createAddress(AddressesPOJO address){
        return addressDao.save(address);
    }

    public AddressesPOJO getAddress(String addressId){
        return addressDao.findOne(addressId);
    }

    public AddressesPOJO updateAddress(String id, AddressesPOJO address){
        AddressesPOJO oldAddress= addressDao.findOne(id);
        oldAddress.setState(address.getState()!=null?address.getState():oldAddress.getState());
        oldAddress.setStreet(address.getStreet()!=null?address.getStreet():oldAddress.getStreet());
        oldAddress.setStreet2(address.getStreet2()!=null?address.getStreet2():oldAddress.getStreet2());
        oldAddress.setZipCode(address.getZipCode()!=null?address.getZipCode():oldAddress.getZipCode());
        addressDao.save(address);
        return oldAddress;
    }

    public void deleteAddress(String id){
        addressDao.delete(id);
    }

    public List<AddressesPOJO> getList(AddressesPOJO addressCriteria, int pageSize, int pageNumber, String filters, String sortBy){
        Criteria filterCriteria = filterHelper.getFilteredCriteria(addressCriteria, pageSize, pageNumber, filters, sortBy);
        return null;
    }

}
