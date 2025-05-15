
package com.mkyong.json.jackson.tips;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.json.model.Person;

public class City {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    String Name;
    int latitude;
    int longitude;

    public City(String name, int latitude, int longitude) {
        Name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void City jsonImport() {

    }

}
