package org.WeatherReports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class TestListObjectMaper {
    static File myJsonFile;
    static Scanner myReader;
    static String jsonPath = "C:\\Users\\Witek\\IdeaProjects\\WeatherReports\\src\\main\\resources\\";
    static String jsonString = "";
    static City city;

    public static void main(String[] args) {

        try {
            myJsonFile = new File(jsonPath+"cities.json");
            myReader = new Scanner(myJsonFile);
            if (myReader.hasNextLine()) {
                jsonString = myReader.nextLine();
                System.out.println(jsonString);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        List<City> cityList = null;
        try {
            // covert JSON table file to list Java object
            cityList = om.readValue(jsonString, new TypeReference<List<City>>(){});
            //for (City city : cityList) {
              //  System.out.println(City.name);
            //}
            Iterator<City> cityIterator = cityList.iterator();
            while (cityIterator.hasNext()) {
                city = cityIterator.next();
                System.out.println(city.name);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

