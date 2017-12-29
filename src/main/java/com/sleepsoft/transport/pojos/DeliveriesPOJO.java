package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deliveries", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
public class DeliveriesPOJO extends BaseEntity{
    private Date deliveryRequest;
    private Long charge;
    private Date deliveryDate;
    @ManyToOne (cascade = CascadeType.ALL)
    TransportistsPOJO transport;
}
