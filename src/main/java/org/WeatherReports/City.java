// Klasa City: miasto dla którego będziemy wyszukiwac prognozę pogody, elementu zbioru Cities

// package com.mkyong.json.jackson.tips;
// import com.mkyong.json.model.Person;
package org.WeatherReports;

public class City {
    public String name = "";
    public Coord coord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public City() {
        this.name = "";
        this.coord = new Coord();
    }

    public City(String name) {
        this.name = name;
        this.coord = new Coord();
    }

    public City(String name, Coord coord) {
        this.name = name;
        this.coord = coord;
    }

    public class Coord {
        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        double lon=0.0;
        double lat=0.0;

        public Coord() {
            this.lon = 0.0;
            this.lat = 0.0;
        }
        public Coord(double latitude, double lon) {
            this.lon = lon;
            this.lat = lat;
        }
    }


}
