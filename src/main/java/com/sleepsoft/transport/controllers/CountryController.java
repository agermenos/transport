package com.sleepsoft.transport.controllers;

import com.sleepsoft.transport.pojos.CountriesPOJO;
import com.sleepsoft.transport.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("countries")
public class CountryController extends BaseController{
    final
    CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<CountriesPOJO>> getCountryes(
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam(name = "sortby", required = false) String sortby,
            Pageable pageable)
    {
        CountriesPOJO countryCriteria = new CountriesPOJO(filter);
        Optional<Iterable<CountriesPOJO>> optionalCountriesPOJOList =
                countryService.findAllByCriteria(countryCriteria);
        return (ResponseEntity<Iterable<CountriesPOJO>>) getResponse(optionalCountriesPOJOList);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<CountriesPOJO> getCountry(@PathVariable String id){
        Optional<CountriesPOJO> optionalCountriesPOJO = countryService.findById(id);
        return (ResponseEntity<CountriesPOJO>) getResponse(optionalCountriesPOJO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CountriesPOJO> createCountries(@RequestParam CountriesPOJO country){
        Optional<CountriesPOJO> optionalPojo = countryService.createCountry(country);
        return (ResponseEntity<CountriesPOJO>) getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CountriesPOJO> updateCountry(@RequestParam CountriesPOJO country, @PathVariable("id") String id){
        Optional<CountriesPOJO> optionalPojo = countryService.updateCountry(id, country);
        return (ResponseEntity<CountriesPOJO>) getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CountriesPOJO> deleteCountry(@PathVariable String id){
        countryService.deleteCountry(id);
        return (ResponseEntity<CountriesPOJO>) ResponseEntity.noContent();
    }

}

