package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.BusinessesPOJO;
import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StatesDao extends CrudRepository<StatesPOJO, String>,
        QueryByExampleExecutor<BusinessesPOJO> {
    StatesPOJO findByState(String state);
    Iterable<StatesPOJO> findAllByCountry(String countryId);
}
