// Klasa Cities: zbiór miast - "baza danych miast dla których będziemy wyszukiwac prognozę pogody.
// Zbiór miast to może być lista albo HashMap (wydorbać optymalną strukturę)
// package org.WeatherReports;
package org.WeatherReports;
//import java.lang;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

// import City.java;

public class Cities {

    City city;
    HashMap<String, City> cities = new HashMap<>();

    public void loadCities(String pathToJson) {
        System.out.println("ladujemy jsona "+pathToJson);

        String json = "{\"name\": \"mkyong\", \"age\": 20}";

        ObjectMapper om = new ObjectMapper();
        try {

            // covert JSON to Java object
            Cities cities = om.readValue(json, Cities.class);

            // output: Person{name='mkyong', age=20}
            System.out.println(cities);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public City getCity(String myCity) {
        return cities.get(myCity);
    }

    public void printCities() {
        for (String ct : cities.keySet()) {
            System.out.println(ct);
        }
    }

}
