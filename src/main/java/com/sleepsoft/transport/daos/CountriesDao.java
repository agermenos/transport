package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.CountriesPOJO;
import org.springframework.data.repository.CrudRepository;

public interface CountriesDao  extends CrudRepository<CountriesPOJO, String> {
    CountriesPOJO findByCountry(String country);
}
