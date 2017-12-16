package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.TypeCatalogDao;
import com.sleepsoft.transport.pojos.TypeCatalogsPOJO;
import com.sleepsoft.transport.pojos.enums.CatalogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    @Autowired
    TypeCatalogDao catalogDao;
    public TypeCatalogsPOJO getCatalog(CatalogType type){
        return catalogDao.findByType(type.definition());
    }

    public void createCatalog(TypeCatalogsPOJO  catalogsPOJO){
        catalogDao.save(catalogsPOJO);
    }

    public TypeCatalogsPOJO updateCatalog(String id, TypeCatalogsPOJO newCatalogPOJO){
        TypeCatalogsPOJO originalCatalog = catalogDao.findOne(id);
        if (originalCatalog!=null){
            originalCatalog.setType(newCatalogPOJO.getType()!=null?newCatalogPOJO.getType():originalCatalog.getType());
            originalCatalog.setParent(newCatalogPOJO.getParent()!=null?newCatalogPOJO.getParent():originalCatalog.getParent());
            catalogDao.save(originalCatalog);
        }
        return originalCatalog;
    }

    public void deleteCatalog(String id){
        catalogDao.delete(id);
    }
}
