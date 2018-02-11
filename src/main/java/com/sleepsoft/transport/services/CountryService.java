package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.CountriesDao;
import com.sleepsoft.transport.pojos.CountriesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("countryService")
public class CountryService {
    @Autowired
    CountriesDao countriesDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public CountriesPOJO createCountry(CountriesPOJO country){
        return countriesDao.save(country);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public CountriesPOJO findByCountry(String country){
        return countriesDao.findByCountry(country);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public CountriesPOJO findById(String countryId){
        return countriesDao.findOne(countryId);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public CountriesPOJO updateCountry(String id, CountriesPOJO country){
        CountriesPOJO originalCountry = countriesDao.findOne(id);
        originalCountry.setCountry(country.getCountry()!=null? country.getCountry():originalCountry.getCountry());
        return countriesDao.save(originalCountry);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public void deleteCountry(String countryId){
        countriesDao.delete(countryId);
    }
    
}
