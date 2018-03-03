package com.sleepsoft.transport.pojos;

import com.sleepsoft.transport.util.FilterHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;

import javax.persistence.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "representatives", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class BusinessesPOJO extends BaseEntity{
    private String name;
    private String lastName;
    @ManyToOne
    AddressesPOJO address;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "businesses_contact", catalog = "transport", joinColumns = {
            @JoinColumn(name = "business_id", referencedColumnName = "id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "contact_id",
                    nullable = false, updatable = false) })
    Set<ContactsPOJO> contacts;

    public BusinessesPOJO(String filter) {
        try {
            List<NameValuePair> valuePairList = FilterHelper.getNameValuePair(filter);
            valuePairList.forEach(nameValuePair -> {
                switch (nameValuePair.getName().toLowerCase().trim()){
                    case "business_name": setName(nameValuePair.getValue());
                    case "business_lastname": setLastName(nameValuePair.getValue());
                }
            });
            if (filter.toLowerCase().contains("address_")) {
                AddressesPOJO addressPOJO = new AddressesPOJO(filter);
                setAddress(addressPOJO);
            }
        } catch (URISyntaxException e) {
            log.error(e.getMessage());
        }
    }
}
