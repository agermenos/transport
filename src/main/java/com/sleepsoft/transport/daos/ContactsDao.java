package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.ContactsPOJO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ContactsDao extends CrudRepository<ContactsPOJO, String>, QueryByExampleExecutor<ContactsPOJO> {
}
