package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.TransportistsPOJO;
import org.springframework.data.repository.CrudRepository;

public interface TransportistsDao extends CrudRepository<TransportistsPOJO, String>{
}
