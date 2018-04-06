package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.DeliveriesDao;
import com.sleepsoft.transport.pojos.DeliveriesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service("deliveriesService")
public class DeliveriesService {
    final
    DeliveriesDao deliveriesDao;

    @Autowired
    public DeliveriesService(DeliveriesDao deliveriesDao) {
        this.deliveriesDao = deliveriesDao;
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<DeliveriesPOJO> findById(String id){
        return Optional.ofNullable(deliveriesDao.findOne(id));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<Iterable<DeliveriesPOJO>> findAllByCriteria(DeliveriesPOJO deliveriesPOJO){
        Example<DeliveriesPOJO> example = Example.of(deliveriesPOJO);
        return Optional.ofNullable(deliveriesDao.findAll(example));
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Optional<DeliveriesPOJO> findOneByCriteria(DeliveriesPOJO deliveriesPOJO){
        Example<DeliveriesPOJO> example = Example.of(deliveriesPOJO);
        return Optional.ofNullable(deliveriesDao.findOne(example));
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Optional<DeliveriesPOJO> updateDeliveries(String id, DeliveriesPOJO deliveries){
        DeliveriesPOJO originalDeliveries=null;
        Optional<DeliveriesPOJO> tryOriginalDeliveries = findById(id);
        if(tryOriginalDeliveries.isPresent()) {
            originalDeliveries = tryOriginalDeliveries.get();
            originalDeliveries.setCharge(deliveries.getCharge() != null ? deliveries.getCharge() : originalDeliveries.getCharge());
            originalDeliveries.setDeliveryDate(deliveries.getDeliveryDate() != null ? deliveries.getDeliveryDate() : originalDeliveries.getDeliveryDate());
            originalDeliveries.setDeliveryRequest(deliveries.getDeliveryRequest() != null ? deliveries.getDeliveryRequest() : originalDeliveries.getDeliveryRequest());
            originalDeliveries.setTransport(deliveries.getTransport() != null ? deliveries.getTransport() : originalDeliveries.getTransport());
            deliveriesDao.save(originalDeliveries);
        }
        return Optional.ofNullable(originalDeliveries);
    }


}
