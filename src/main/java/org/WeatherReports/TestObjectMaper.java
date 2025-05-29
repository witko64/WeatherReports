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
        City city = new City();
        try {
            // covert JSON to Java object
            city = om.readValue(json, City.class);
            System.out.println(city.name+city.coord);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        City city1 = city;
        try {
            // convert Java object to JSON
            om.writeValue(new File("target/city1.json"), city1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
