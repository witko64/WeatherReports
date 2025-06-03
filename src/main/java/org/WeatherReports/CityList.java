// Klasa Cities: lista miast - "baza danych miast dla których będziemy wyszukiwac prognozę pogody.

package org.WeatherReports;
//import java.lang;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class CityList {
    static File myJsonFile;
    static Scanner myReader;
    static String jsonPath = "C:\\Users\\Witek\\IdeaProjects\\WeatherReports\\src\\main\\resources\\";
    static String jsonString = "";
    City city;
    List<City> cityList = null;

    public CityList() {
        // Read table of cities from JSON file to JSON string
        try {
            myJsonFile = new File(jsonPath + "cities.json");
            myReader = new Scanner(myJsonFile);
            if (myReader.hasNextLine()) {
                jsonString = myReader.nextLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        try {
            // covert JSON table file to list Java object
            cityList = om.readValue(jsonString, new TypeReference<List<City>>(){});
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public City getCity(String myCity) {
        for (City value : cityList) {
            city = value;
            if (Objects.equals(city.name.toUpperCase(), myCity.toUpperCase())) {
                break;
            }
        }
        if (!Objects.equals(city.name.toUpperCase(), myCity.toUpperCase())) {
            city = null;
        }
        return city;
    }

    public void printCities() {
        for (City value : cityList) {
            city = value;
            System.out.print(city.name+" ");
        }
        System.out.println(" ");
    }
}
