package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "countries", schema = "public", catalog = "transport")
@Data
public class CountriesPOJO extends BaseEntity{
    private String country;
    @OneToMany
    List<StatesPOJO> states;
}
