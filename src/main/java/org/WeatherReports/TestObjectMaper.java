package org.WeatherReports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestObjectMaper {

    public static void main(String[] args) {
        String json = "{\"name\": \"Gdynia\", \"coord\":{\"lon\":18.55,\"lat\":54.52}}";
        String json1 = "";
        ObjectMapper om = new ObjectMapper();

        City city1 = new City("Poznan");

        try {
            //om.writeValue(json1, city1);
            om.writeValue(new File("target/city.json"), city1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            City city = new City();

            // covert JSON to Java object
            city = om.readValue(json, City.class);

            // output: Person{name='mkyong', age=20}
            System.out.println(city);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
