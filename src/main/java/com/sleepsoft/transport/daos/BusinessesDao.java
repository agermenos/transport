package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.BusinessesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BusinessesDao extends CrudRepository<BusinessesPOJO, String>,
        QueryByExampleExecutor<BusinessesPOJO> {
}
