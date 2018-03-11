package com.sleepsoft.transport.controllers;

import com.sleepsoft.transport.pojos.StatesPOJO;
import com.sleepsoft.transport.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class StateController extends BaseController{
    @Autowired
    StateService stateService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<StatesPOJO>> getStatees(
            @PathVariable(name = "filter", required = false) String filter,
            @PathVariable(name = "sortby", required = false) String sortby,
            Pageable pageable)
    {
        StatesPOJO stateCriteria = new StatesPOJO(filter);
        Optional<Iterable<StatesPOJO>> optionalStatesPOJOList =
                filter==null?stateService.findAllByCountry(""):
                        stateService.findAllByCountry("");
        return getResponse(optionalStatesPOJOList);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatesPOJO> getState(@PathVariable String id){
        Optional<StatesPOJO> optionalStatesPOJO = stateService.findById(id);
        return getResponse(optionalStatesPOJO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StatesPOJO> createStates(@RequestParam StatesPOJO state){
        Optional<StatesPOJO> optionalPojo = stateService.createstate(state);
        return getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StatesPOJO> updateState(@RequestParam StatesPOJO state){
        Optional<StatesPOJO> optionalPojo = stateService.updateState(state.getId(), state);
        return getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StatesPOJO> deleteState(@PathVariable String id){
        stateService.deletestate(id);
        return (ResponseEntity<StatesPOJO>) ResponseEntity.noContent();
    }

}

