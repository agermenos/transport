package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "transportists", schema = "public", catalog = "transport")
public class TransportistsPOJO extends BaseEntity{
    private String name;
    private Long stars;
    @ManyToOne
    RepresentativesPOJO representative;
    @OneToMany
    List<DeliveriesPOJO> deliveries;
}
