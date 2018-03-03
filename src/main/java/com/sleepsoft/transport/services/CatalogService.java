package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.TypeCatalogDao;
import com.sleepsoft.transport.pojos.TypeCatalogsPOJO;
import com.sleepsoft.transport.pojos.enums.CatalogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("catalogService")
public class CatalogService {
    @Autowired
    TypeCatalogDao catalogDao;

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<TypeCatalogsPOJO> findById(String id){
        return Optional.of(catalogDao.findOne(id));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<TypeCatalogsPOJO> getCatalog(CatalogType type){
        return Optional.of(catalogDao.findByType(type.definition()));
    }

    @Transactional(readOnly = true, propagation= Propagation.REQUIRED)
    public Optional<TypeCatalogsPOJO> createCatalog(TypeCatalogsPOJO  catalogsPOJO){
        TypeCatalogsPOJO searchCatalog = catalogDao.findByType(catalogsPOJO.getType());
        if (searchCatalog!=null) {
            if (searchCatalog.equals(catalogsPOJO))
            return Optional.of(searchCatalog);
        }
        return Optional.of(catalogDao.save(catalogsPOJO));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<TypeCatalogsPOJO> updateCatalog(String id, TypeCatalogsPOJO newCatalogPOJO){
        TypeCatalogsPOJO originalCatalog = catalogDao.findOne(id);
        if (originalCatalog!=null){
            originalCatalog.setType(newCatalogPOJO.getType()!=null?newCatalogPOJO.getType():originalCatalog.getType());
            originalCatalog.setParent(newCatalogPOJO.getParent()!=null?newCatalogPOJO.getParent():originalCatalog.getParent());
            catalogDao.save(originalCatalog);
        }
        return Optional.of(originalCatalog);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public void deleteCatalog(String id){
        catalogDao.delete(id);
    }
}
