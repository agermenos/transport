package com.sleepsoft.transport.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class FilterHelper<T> {
    private Class<T> entityClass;;
    @PersistenceContext
    private EntityManager em;

    public FilterHelper(Class<T> entityClass){
        this.entityClass = entityClass;
        //this.em = em;
    }

    public static List<NameValuePair> getNameValuePair(String url) throws URISyntaxException {
         return URLEncodedUtils.parse(new URI(url), "UTF-8");
    }

    public Criteria getFilteredCriteria(Object criteriaBearer, int pageSize, int pageNumber, String filters, String sortBy) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        return null;
    }
}
