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
@Table(name = "states", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class StatesPOJO extends BaseEntity{
    private String state;
    @ManyToOne
    CountriesPOJO country;

    public StatesPOJO(String filter) {
        try {
            List<NameValuePair> valuePairList = FilterHelper.getNameValuePair(filter);
            valuePairList.forEach(nameValuePair -> {
                switch (nameValuePair.getName().toLowerCase().trim()){
                    case "state_state": setState(nameValuePair.getValue());
                }
            });
            if (filter.toLowerCase().contains("country")) {
                CountriesPOJO countryPOJO = new CountriesPOJO(filter);
            }
        } catch (URISyntaxException e) {
            log.error(e.getMessage());
        }
    }
}
