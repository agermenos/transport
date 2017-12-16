package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "addresses", schema = "public", catalog = "transport")
@Data
public class AddressesPOJO extends BaseEntity{
    private String street;
    @Column(name = "street_2")
    private String street2;
    private String zipCode;
    @ManyToOne
    private StatesPOJO state;
}
