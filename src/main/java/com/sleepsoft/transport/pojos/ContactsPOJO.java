package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "contacts", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactsPOJO extends BaseEntity implements Serializable{
    private String contact;
    @ManyToOne (cascade = CascadeType.ALL)
    private TypeCatalogsPOJO contactType;
    @OneToMany
    @JoinTable(name = "representative_contacts", catalog = "transport", joinColumns = {
            @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "representative_id",
                    nullable = false, updatable = false) })
    Set<RepresentativesPOJO> representatives;
}
