package com.sleepsoft.transport.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "states", schema = "public", catalog = "transport")
@Data
@EqualsAndHashCode(callSuper=true)
@Slf4j
public class StatesPOJO extends BaseEntity{
    private String state;
    @ManyToOne()
    CountriesPOJO country;
    private String code;

    public StatesPOJO(){
        super();
    }

    public StatesPOJO(String filter) {
        try {
            id=null;
            if (filter!=null) {
                String[] pairs=filter.split("\\s*,\\s*");
                Arrays.stream(pairs).forEach(valuePair -> {
                    String[] keyValue=valuePair.split("\\s*=\\s*");
                    switch (keyValue[0].toLowerCase().trim()) {
                        case "state":
                            setState(keyValue[1]);
                            break;
                        case "code":
                            setCode(keyValue[1]);
                            break;
                    }
                });
                if (filter.toLowerCase().contains("country")) {
                    CountriesPOJO countryPOJO = new CountriesPOJO(filter.replace("country.", ""));
                    setCountry(countryPOJO);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }



    public boolean isEmpty() {
        return this.country==null &&
                this.state==null &&
                this.code==null;
    }
}
