package org.WeatherReports;
//import java.util;
//import java.Cities;
//import java.SimpleMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    protected static String PATH_TO_JSON = "c:\\cities.json";

    public static void main(String[] args) {
        Cities cities = new Cities();
        cities.loadCities(PATH_TO_JSON); //load cities database from json file
        SimpleMenu myMenu = new SimpleMenu();
        String menuItem;
        menuItem = myMenu.getMenuItem();
        City myCity;
        myCity = cities.getCity(menuItem);
    }
}