package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.TransportApplication;
import com.sleepsoft.transport.pojos.AddressesPOJO;
import com.sleepsoft.transport.pojos.CountriesPOJO;
import com.sleepsoft.transport.pojos.StatesPOJO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TransportApplication.class})
@Ignore
public class AddressDaoTest {
    @Autowired
    AddressDao addressDao;
    @Autowired
    CountriesDao countriesDao;
    @Autowired
    StatesDao statesDao;
    @Test
    public void CRUDTest(){
        //CREATE Test
        CountriesPOJO countryPOJO = new CountriesPOJO();
        countryPOJO.setCountry("United States");
        countriesDao.save(countryPOJO);
        StatesPOJO statesPOJO = new StatesPOJO();
        statesPOJO.setState("California");
        statesPOJO.setCountry(countryPOJO);
        statesDao.save(statesPOJO);
        AddressesPOJO addressesPOJO = new AddressesPOJO();
        addressesPOJO.setStreet("3420 Finnian Way");
        addressesPOJO.setStreet2("Apt. 408");
        addressesPOJO.setZipCode("94568");
        addressesPOJO.setState(statesPOJO);
        addressDao.save(addressesPOJO);
    }
}
