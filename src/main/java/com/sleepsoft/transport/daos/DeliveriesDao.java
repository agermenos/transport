package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.DeliveriesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface DeliveriesDao extends CrudRepository<DeliveriesPOJO, String>, QueryByExampleExecutor<DeliveriesPOJO>{
}
