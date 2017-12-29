package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "states", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
public class StatesPOJO extends BaseEntity{
    private String state;
    @ManyToOne
    CountriesPOJO country;
}
