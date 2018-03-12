package com.sleepsoft.transport.controllers;

import com.sleepsoft.transport.pojos.BusinessesPOJO;
import com.sleepsoft.transport.services.BusinessesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("businesses")
public class BusinessController extends BaseController{
    @Autowired
    BusinessesService businessesService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<BusinessesPOJO>> getBusinesses(
            @PathVariable(name = "filter", required = false) String filter,
            @PathVariable(name = "sortby", required = false) String sortby,
            Pageable pageable)
    {
        BusinessesPOJO businessCriteria = new BusinessesPOJO(filter);
        Optional<Iterable<BusinessesPOJO>> optionalBusinessesPOJOList =
                        businessesService.findAllByCriteria(businessCriteria);
        return getResponse(optionalBusinessesPOJOList);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<BusinessesPOJO> getBusiness(@PathVariable String id){
        Optional<BusinessesPOJO> optionalBusinessesPOJO = businessesService.findById(id);
        return getResponse(optionalBusinessesPOJO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BusinessesPOJO> createBusinesses(@RequestParam BusinessesPOJO business){
        Optional<BusinessesPOJO> optionalPojo = businessesService.createBusiness(business);
        return getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BusinessesPOJO> updateBusiness(@RequestParam BusinessesPOJO business){
        Optional<BusinessesPOJO> optionalPojo = businessesService.updateContact(business.getId(), business);
        return getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BusinessesPOJO> deleteBusiness(@PathVariable String id){
        businessesService.deleteService(id);
        return (ResponseEntity<BusinessesPOJO>) ResponseEntity.noContent();
    }

}
