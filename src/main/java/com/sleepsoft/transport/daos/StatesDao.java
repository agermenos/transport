package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StatesDao extends CrudRepository<StatesPOJO, String>,
        QueryByExampleExecutor<StatesPOJO> {
    @Override
    StatesPOJO findOne(String s);
}
