package com.sleepsoft.transport.pojos;

import com.sleepsoft.transport.util.FilterHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.net.URISyntaxException;
import java.util.List;

@Entity
@Table(name = "countries", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class CountriesPOJO extends BaseEntity{
    private String country;

    public CountriesPOJO(){
        super();
    }

    public CountriesPOJO(String filter) {
        try {
            List<NameValuePair> valuePairList = FilterHelper.getNameValuePair(filter);
            valuePairList.forEach(nameValuePair -> {
                switch (nameValuePair.getName().toLowerCase().trim()){
                    case "country_country": setCountry(nameValuePair.getValue());
                }
            });
        } catch (URISyntaxException e) {
            log.error(e.getMessage());
        }
    }
}
