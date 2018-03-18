package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.CountriesPOJO;
import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CountriesDao  extends CrudRepository<CountriesPOJO, String>,
        QueryByExampleExecutor<CountriesPOJO> {
    CountriesPOJO findByCountry(String country);
}
