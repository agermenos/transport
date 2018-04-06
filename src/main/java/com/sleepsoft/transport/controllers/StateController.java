package com.sleepsoft.transport.controllers;

import com.sleepsoft.transport.pojos.StatesPOJO;
import com.sleepsoft.transport.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("states")
public class StateController extends BaseController{
    final
    StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<StatesPOJO>> getStatees(
            @RequestParam(name = "filter", required = false) String filter,
            @RequestParam(name = "sortby", required = false) String sortby,
            Pageable pageable)
    {
        StatesPOJO stateCriteria = new StatesPOJO(filter);
        Optional<Iterable<StatesPOJO>> optionalStatesPOJOList =
                        stateService.findAllByCriteria(stateCriteria);
        return (ResponseEntity<Iterable<StatesPOJO>>) getResponse(optionalStatesPOJOList);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatesPOJO> getState(@PathVariable String id){
        Optional<StatesPOJO> optionalStatesPOJO = stateService.findById(id);
        return (ResponseEntity<StatesPOJO>) getResponse(optionalStatesPOJO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StatesPOJO> createStates(@RequestParam StatesPOJO state){
        Optional<StatesPOJO> optionalPojo = stateService.createState(state);
        return (ResponseEntity<StatesPOJO>) getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StatesPOJO> updateState(@RequestParam StatesPOJO state, @PathVariable("id") String id){
        Optional<StatesPOJO> optionalPojo = stateService.updateState(id, state);
        return (ResponseEntity<StatesPOJO>) getResponse(optionalPojo);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<StatesPOJO> deleteState(@PathVariable String id){
        stateService.deleteState(id);
        return (ResponseEntity<StatesPOJO>) ResponseEntity.noContent();
    }

}

