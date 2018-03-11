package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.BusinessesDao;
import com.sleepsoft.transport.pojos.BusinessesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("businessesService")
public class BusinessesService {
    @Autowired
    BusinessesDao businessesDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<BusinessesPOJO> createBusiness(BusinessesPOJO businesses){
        BusinessesPOJO returnPOJO = businessesDao.save(businesses);
        return Optional.of(returnPOJO);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<BusinessesPOJO>> findAllByCriteria(BusinessesPOJO business){
        Example<BusinessesPOJO> example = Example.of(business);
        return Optional.of(businessesDao.findAll(example));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<BusinessesPOJO> findById(String businessId){
        return Optional.of(businessesDao.findOne(businessId));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<BusinessesPOJO> updateContact(String id, BusinessesPOJO business){
        BusinessesPOJO originalBusiness = businessesDao.findOne(id);
        if (originalBusiness==null) return Optional.empty();
        originalBusiness.setLastName(business.getLastName()!=null?business.getLastName():originalBusiness.getLastName());
        originalBusiness.setName(business.getName()!=null?business.getName():originalBusiness.getName());
        return Optional.of(businessesDao.save(originalBusiness));
    }

    public void deleteService(String id) {
        businessesDao.delete(id);
    }
}
