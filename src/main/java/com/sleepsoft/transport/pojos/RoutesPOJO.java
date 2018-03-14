package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "routes", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
public class RoutesPOJO extends BaseEntity{
    private Long distance;
    @ManyToOne
    @JoinColumn(name = "origin_state")
    StatesPOJO originState;
    @ManyToOne
    @JoinColumn(name = "destination_state")
    StatesPOJO destinationState;

    @Override
    public boolean isEmpty() {
        return distance==null &&
                originState==null &&
                destinationState==null;
    }
}
