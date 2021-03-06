package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "transportists", schema = "public", catalog = "transport")
@EqualsAndHashCode(callSuper=true)
public class TransportistsPOJO extends BaseEntity{
    private String name;
    private Long stars;
    @ManyToOne
    BusinessesPOJO representative;
    @OneToMany
    List<DeliveriesPOJO> deliveries;

    public boolean isEmpty(){
        return representative.isEmpty() &&
                deliveries.isEmpty() &&
                name==null &&
                stars==null;
    }
}
