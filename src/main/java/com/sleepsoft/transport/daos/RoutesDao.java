package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.RoutesPOJO;
import org.springframework.data.repository.CrudRepository;

public interface RoutesDao extends CrudRepository<RoutesPOJO, String> {
}
