package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.TransportApplication;
import com.sleepsoft.transport.pojos.TypeCatalogsPOJO;
import com.sleepsoft.transport.pojos.enums.CatalogType;
import com.sleepsoft.transport.services.CatalogService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TransportApplication.class})
@Ignore
public class CatalogDaoTest {
    @Autowired
    TypeCatalogDao catalogDao;
    @Autowired
    CatalogService catalogService;

    private TypeCatalogsPOJO createChild(String definition, TypeCatalogsPOJO parent){
        TypeCatalogsPOJO child = new TypeCatalogsPOJO();
        child.setType(definition);
        child.setParent(parent);
        return child;
    }

    //@Test
    public void testCatalogCreation(){
        TypeCatalogsPOJO parent = new TypeCatalogsPOJO();
        Set<TypeCatalogsPOJO> children = new HashSet<>();
        parent.setType(CatalogType.CONTACT_TYPE);
        TypeCatalogsPOJO child1 = createChild("Seller", parent);
        TypeCatalogsPOJO child2 = createChild("Buyer", parent);
        catalogDao.save(parent);
        catalogDao.save(child1);
        catalogDao.save(child2);
    }

    @Test
    public void getCatalogTest(){
        TypeCatalogsPOJO parent = catalogService.getCatalog(CatalogType.CONTACT_TYPE);
        System.out.println("Parent: "+ parent.toString());
        parent.getChildren().stream().forEach(
                child -> System.out.println(child.toString())
        );
    }
}
