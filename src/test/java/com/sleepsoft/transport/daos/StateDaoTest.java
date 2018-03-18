package com.sleepsoft.transport.daos;

import com.sleepsoft.transport.TransportApplication;
import com.sleepsoft.transport.pojos.CountriesPOJO;
import com.sleepsoft.transport.pojos.StatesPOJO;
import com.sleepsoft.transport.services.StateService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TransportApplication.class})
@Slf4j
public class StateDaoTest {
    @Autowired
    StatesDao statesDao;

    public static String US_STATES_URL="https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States";
    private static String US_ID ="emx2v1zsqjkv1b9x2pl";
    @Autowired
    StateService stateService;

    @Test
    public void addStates(){
        try {
            CountriesPOJO usPOJO=new CountriesPOJO();
            usPOJO.setCountry("United States");
            usPOJO.setCode("US");
            usPOJO.setId(US_ID);
            Document doc = Jsoup.connect(US_STATES_URL).get();
            Element table = doc.select("table").get(0);
            Element t_body = table.select("tbody").get(0);
            Elements tr = t_body.select("tr");
            int headCount=0;
            for (Element element:tr) {
                if (headCount++>1) {
                    StatesPOJO state = new StatesPOJO();
                    Element th = element.select("th").get(0);
                    Element a = th.select("a").get(0);
                    state.setState(a.attr("title"));
                    Elements tds = element.select("td");
                    state.setCountry(usPOJO);
                    state.setCode(tds.get(0).text());
                    log.debug(state.toString());
                    statesDao.save(state);
                }
            }

        } catch (IOException e) { }
    }
}
