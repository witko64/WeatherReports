// Klasa City: miasto dla którego będziemy wyszukiwac prognozę pogody, element CityList

package org.WeatherReports;

public class City {
    public String name = "";
    public Coord coord;

    public City() {
        this.name = "";
        this.coord = new Coord();
    }
}