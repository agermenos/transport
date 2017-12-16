package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "states", schema = "public", catalog = "transport")
@Data
public class StatesPOJO extends BaseEntity{
    private String state;
    @ManyToOne
    CountriesPOJO country;
}
