package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "transportist_prices", schema = "public", catalog = "transport")
public class TransportistPricesPOJO extends BaseEntity{
    private Long price;
    @ManyToOne
    RoutesPOJO route;
    @ManyToOne
    TransportistsPOJO transportist;
    @ManyToOne
    TypeCatalogsPOJO transportType;
}
