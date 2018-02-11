package com.sleepsoft.transport.services;

import com.sleepsoft.transport.daos.DeliveriesDao;
import com.sleepsoft.transport.pojos.DeliveriesPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("deliveriesService")
public class DeliveriesService {
    @Autowired
    DeliveriesDao deliveriesDao;

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public DeliveriesPOJO findById(String id){
        return deliveriesDao.findOne(id);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public Iterable<DeliveriesPOJO> findAllByCriteria(DeliveriesPOJO deliveriesPOJO){
        Example<DeliveriesPOJO> example = Example.of(deliveriesPOJO);
        return deliveriesDao.findAll(example);
    }

    @Transactional(readOnly = true, propagation=Propagation.REQUIRED)
    public DeliveriesPOJO findOneByCriteria(DeliveriesPOJO deliveriesPOJO){
        Example<DeliveriesPOJO> example = Example.of(deliveriesPOJO);
        return deliveriesDao.findOne(example);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public DeliveriesPOJO updateDeliveries(String id, DeliveriesPOJO deliveries){
        DeliveriesPOJO originalDeliveries = findById(id);
        originalDeliveries.setCharge(deliveries.getCharge()!=null?deliveries.getCharge():originalDeliveries.getCharge());
        originalDeliveries.setDeliveryDate(deliveries.getDeliveryDate()!=null?deliveries.getDeliveryDate():originalDeliveries.getDeliveryDate());
        originalDeliveries.setDeliveryRequest(deliveries.getDeliveryRequest()!=null?deliveries.getDeliveryRequest():originalDeliveries.getDeliveryRequest());
        originalDeliveries.setTransport(deliveries.getTransport()!=null?deliveries.getTransport():originalDeliveries.getTransport());
        return deliveriesDao.save(originalDeliveries);
    }


}
