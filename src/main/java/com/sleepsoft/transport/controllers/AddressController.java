package com.sleepsoft.transport.controllers;

import com.sleepsoft.transport.pojos.AddressesPOJO;
import com.sleepsoft.transport.pojos.BusinessesPOJO;
import com.sleepsoft.transport.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{
    @Autowired
    AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<BusinessesPOJO>> getBusinesses(
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam(name = "sortby", required = false) String sortby,
            Pageable pageable)
    {
        AddressesPOJO addressCriteria = new AddressesPOJO(filter);
        Optional<Iterable<AddressesPOJO>> optionalAddressesPOJOIterable =
               addressService.findAllByCriteria(addressCriteria);
        return (ResponseEntity<Iterable<BusinessesPOJO>>) getResponse(optionalAddressesPOJOIterable);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<AddressesPOJO> getAddress(@PathVariable String id){
        Optional<AddressesPOJO> optionalAddressesPOJO = addressService.findById(id);
        return (ResponseEntity<AddressesPOJO>) getResponse(optionalAddressesPOJO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AddressesPOJO> createAddress(@RequestParam AddressesPOJO address){
        Optional<AddressesPOJO> optionalPojo = addressService.createAddress(address);
        return (ResponseEntity<AddressesPOJO>) getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AddressesPOJO> updateAddress(@RequestParam AddressesPOJO address, @PathVariable("id") String id){
        Optional<AddressesPOJO> optionalPojo = addressService.updateAddress(id, address);
        return (ResponseEntity<AddressesPOJO>) getResponse(optionalPojo);
    }
}
