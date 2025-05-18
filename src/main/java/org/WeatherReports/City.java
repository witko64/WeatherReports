// Klasa City: miasto dla którego będziemy wyszukiwac prognozę pogody, elementu zbioru Cities

// package com.mkyong.json.jackson.tips;
// import com.mkyong.json.model.Person;
package org.WeatherReports;

public class City {
    String Name;
    float latitude;
    float longitude;

    public City(String name, float latitude, float longitude) {
        Name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
