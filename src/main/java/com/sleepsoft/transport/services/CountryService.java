package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.CountriesDao;
import com.sleepsoft.transport.pojos.CountriesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("countryService")
public class CountryService {
    @Autowired
    CountriesDao countriesDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<CountriesPOJO> createCountry(CountriesPOJO country){
        return Optional.of(countriesDao.save(country));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<CountriesPOJO>> findAllByCriteria (CountriesPOJO country){
        if (country.isEmpty()) {
            return Optional.of(countriesDao.findAll());
        }
        country.setId(null  );

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase(true);
        Example<CountriesPOJO> example = Example.of(country, matcher);
        return Optional.of(countriesDao.findAll(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<CountriesPOJO> findByCountry(String country){
        return Optional.of(countriesDao.findByCountry(country));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<CountriesPOJO> findById(String countryId){
        return Optional.of(countriesDao.findOne(countryId));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<CountriesPOJO> updateCountry(String id, CountriesPOJO country){
        CountriesPOJO originalCountry = countriesDao.findOne(id);
        if (originalCountry==null) return Optional.empty();
        originalCountry.setCountry(country.getCountry()!=null? country.getCountry():originalCountry.getCountry());
        return Optional.of(countriesDao.save(originalCountry));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public void deleteCountry(String countryId){
        countriesDao.delete(countryId);
    }
    
}
