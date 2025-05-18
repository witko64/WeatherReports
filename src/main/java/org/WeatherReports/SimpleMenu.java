package org.WeatherReports;

//import City.java;
//import Cities.java;

public class SimpleMenu {

    public SimpleMenu() {
    }

    public void printSimpleMenu(Cities cities)  {
        System.out.println("Select city");
        cities.printCities();
        System.out.println("Write a name of city");
    }

    public String getMenuItem() {
        return "poznan";
    }

}
