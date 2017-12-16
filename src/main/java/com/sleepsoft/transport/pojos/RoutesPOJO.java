package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "routes", schema = "public", catalog = "transport")
@Data
public class RoutesPOJO extends BaseEntity{
    private Long distance;
    @ManyToOne
    @JoinColumn(name = "origin_state")
    StatesPOJO originState;
    @ManyToOne
    @JoinColumn(name = "destination_state")
    StatesPOJO destinationState;
}
