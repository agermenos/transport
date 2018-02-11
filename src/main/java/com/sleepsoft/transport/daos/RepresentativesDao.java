package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.RepresentativesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RepresentativesDao extends CrudRepository<RepresentativesPOJO, String>,
        QueryByExampleExecutor<RepresentativesPOJO> {
}
