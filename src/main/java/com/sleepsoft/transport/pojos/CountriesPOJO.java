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
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "countries", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class CountriesPOJO extends BaseEntity{
    private String country;
    private String code;

    @Override
    public boolean isEmpty() {
        return country==null &&
                code==null;
    }

    public CountriesPOJO(){
        super();
    }

    public CountriesPOJO(String filter) {
        try {
            id=null;
            if (filter!=null) {
                String[] pairs=filter.split("\\s*,\\s*");
                Arrays.stream(pairs).forEach(valuePair -> {
                    String[] keyValue=valuePair.split("\\s*=\\s*");
                    switch (keyValue[0].toLowerCase().trim()) {
                        case "country":
                            setCountry(keyValue[1]);
                            break;
                        case "code":
                            setCode(keyValue[1]);
                            break;
                    }
                });
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
