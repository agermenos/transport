package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.AddressesPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AddressDao extends CrudRepository<AddressesPOJO, String>, QueryByExampleExecutor<AddressesPOJO> {
}
