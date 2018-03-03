package com.sleepsoft.transport.pojos;

import com.sleepsoft.transport.util.FilterHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;

import javax.persistence.*;
import java.net.URISyntaxException;
import java.util.List;

@Entity
@Table(name = "addresses", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class AddressesPOJO extends BaseEntity{
    private String street;
    @Column(name = "street_2")
    private String street2;
    private String zipCode;
    @ManyToOne
    private StatesPOJO state;

    public AddressesPOJO(String filter) {
        try {
            List<NameValuePair> valuePairList = FilterHelper.getNameValuePair(filter);
            valuePairList.forEach(nameValuePair -> {
                switch (nameValuePair.getName().toLowerCase().trim()){
                    case "address_street": setStreet(nameValuePair.getValue());
                    case "address_street2": setStreet2(nameValuePair.getValue());
                    case "address_zipcode": setZipCode(nameValuePair.getValue());
                }
            });
            if (filter.toLowerCase().contains("state")) {
                StatesPOJO statePOJO = new StatesPOJO(filter);
                setState(statePOJO);
            }
        } catch (URISyntaxException e) {
            log.error(e.getMessage());
        }
    }

}
