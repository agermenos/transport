package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.AddressesPOJO;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<AddressesPOJO, String>{
}
