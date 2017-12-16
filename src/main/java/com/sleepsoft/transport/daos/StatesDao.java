package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.data.repository.CrudRepository;

public interface StatesDao extends CrudRepository<StatesPOJO, String> {
}
