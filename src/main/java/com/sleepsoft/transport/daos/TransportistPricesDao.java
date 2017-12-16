package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.TransportistPricesPOJO;
import org.springframework.data.repository.CrudRepository;

public interface TransportistPricesDao extends CrudRepository<TransportistPricesPOJO, String> {
}
