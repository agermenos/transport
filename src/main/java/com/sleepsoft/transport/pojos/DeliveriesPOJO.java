package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deliveries", schema = "public", catalog = "transport")
@Data
public class DeliveriesPOJO extends BaseEntity{
    private Date deliveryRequest;
    private Long charge;
    private Date deliveryDate;
    @ManyToOne (cascade = CascadeType.ALL)
    TransportistsPOJO transport;
}
