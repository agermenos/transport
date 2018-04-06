package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.StatesDao;
import com.sleepsoft.transport.pojos.StatesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("stateService")
public class StateService {
    final
    StatesDao statesDao;

    @Autowired
    public StateService(StatesDao statesDao) {
        this.statesDao = statesDao;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<StatesPOJO> createState(StatesPOJO state){
        return Optional.ofNullable(statesDao.save(state));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> findByState(String state){
        Example<StatesPOJO> example = Example.of(new StatesPOJO("state="+state));
        return Optional.ofNullable(statesDao.findOne(example));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Optional<StatesPOJO> findById(String id){
        return Optional.ofNullable(statesDao.findOne(id));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> findOneByCriteria (StatesPOJO state){
        Example<StatesPOJO> example = Example.of(state);
        return Optional.ofNullable(statesDao.findOne(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<StatesPOJO>> findAllByCriteria (StatesPOJO state){
        if (state.isEmpty()) {
            return Optional.ofNullable(statesDao.findAll());
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase(true);
        Example<StatesPOJO> example = Example.of(state, matcher);
        return Optional.ofNullable(statesDao.findAll(example));
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public Optional<StatesPOJO> updateState(String id, StatesPOJO state){
        StatesPOJO originalState = statesDao.findOne(id);
        if (originalState==null) return Optional.empty();
        originalState.setState(state.getState()!=null? state.getState():originalState.getState());
        return Optional.ofNullable(statesDao.save(originalState));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public void deleteState(String stateId){
        statesDao.delete(stateId);
    }
}
