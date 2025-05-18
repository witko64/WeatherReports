// Klasa Cities: zbiór miast - "baza danych miast dla których będziemy wyszukiwac prognozę pogody.
// Zbiór miast to może być lista albo HashMap (wydorbać optymalną strukturę)
// package org.WeatherReports;
package org.WeatherReports;
//import java.lang;
import java.util.HashMap;

// import City.java;

public class Cities {

    HashMap<String, City> cities = new HashMap<>();

    City city;

    public void loadCities(String pathToJson) {
        System.out.println("ladujemy jsona "+pathToJson);
//        return cities;
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
