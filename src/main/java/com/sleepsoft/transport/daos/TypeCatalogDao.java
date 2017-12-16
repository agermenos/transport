package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.pojos.TypeCatalogsPOJO;
import org.springframework.data.repository.CrudRepository;

public interface TypeCatalogDao extends CrudRepository<TypeCatalogsPOJO, String> {
    TypeCatalogsPOJO findByType(String type);
}
