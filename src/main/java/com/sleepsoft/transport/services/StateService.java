package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.StatesDao;
import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("stateService")
public class StateService {
    @Autowired
    StatesDao statesDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<StatesPOJO> createstate(StatesPOJO state){
        return Optional.of(statesDao.save(state));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> findByState(String state){
        return Optional.of(statesDao.findByState(state));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> findById(String stateId){
        return Optional.of(statesDao.findOne(stateId));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<StatesPOJO>> findAllByCountry(String countryId){
        return Optional.of(statesDao.findAllByCountry(countryId));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> updateState(String id, StatesPOJO state){
        StatesPOJO originalstate = statesDao.findOne(id);
        if (originalstate==null) return null;
        originalstate.setState(state.getState()!=null? state.getState():originalstate.getState());
        return Optional.of(statesDao.save(originalstate));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public void deletestate(String stateId){
        statesDao.delete(stateId);
    }
}
