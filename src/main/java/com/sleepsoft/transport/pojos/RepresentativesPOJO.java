package com.sleepsoft.transport.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "representatives", schema = "public", catalog = "transport")
@Data
public class RepresentativesPOJO extends BaseEntity{
    private String name;
    private String lastName;
    @ManyToOne
    AddressesPOJO address;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "representative_contacts", catalog = "transport", joinColumns = {
            @JoinColumn(name = "representative_id", referencedColumnName = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "contact_id",
                    nullable = false, updatable = false) })
    Set<ContactsPOJO> contacts;
}
