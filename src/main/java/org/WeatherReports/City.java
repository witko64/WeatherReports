// Klasa City: miasto dla którego będziemy wyszukiwac prognozę pogody, elementu zbioru Cities

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
}
