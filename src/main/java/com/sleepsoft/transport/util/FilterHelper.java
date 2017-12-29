package com.sleepsoft.transport.util;

import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FilterHelper<T> {
    private Class<T> entityClass;;
    @PersistenceContext
    private EntityManager em;

    public FilterHelper(Class<T> entityClass){
        this.entityClass = entityClass;
        //this.em = em;
    }

    public Criteria getFilteredCriteria(Object criteriaBearer, int pageSize, int pageNumber, String filters, String sortBy) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        return null;
    }
}
