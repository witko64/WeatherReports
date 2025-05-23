package org.WeatherReports;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Meteo {

//    protected static String PATH_TO_JSON = "c:\\cities.json";

    public static void main(String[] args) throws IOException {
//  Variables
//      Cities cities = new Cities();
//      cities.loadCities(PATH_TO_JSON); //load cities database from json file
//      City myCity;
//      SimpleMenu myMenu = new SimpleMenu();
//      String menuItem;
//
        boolean goOn = true;
        Scanner scanner = new Scanner(System.in);
        String cmd;
        String line;
        MeteoConfig meteoConfig = new MeteoConfig();
        Weather currentWeather = new Weather("Poznan", 16.93,52.41);
        while (goOn) {
            System.out.println("P-podaj miasto, Z-zakończ");
            cmd = scanner.nextLine();
            if (cmd.length() != 0) {
                if (cmd.charAt(0) == 'Z' || cmd.charAt(0) == 'z') {
                    goOn = false;
                }
                else if (cmd.charAt(0) == 'P' || cmd.charAt(0) == 'p') {
//                  myCity = cities.getCity(menuItem);
//                  menuItem = myMenu.getMenuItem();
                    System.out.println("Podaj nazwę miasta");
                    line = scanner.nextLine();
                    System.out.println(line);
                    currentWeather.getWeather(meteoConfig.appID, meteoConfig.restURL ); //Tu ma być token, parametr main()
                    currentWeather.getWeatherReport();
                    currentWeather.createPDF();
                    currentWeather.createXML();
                    currentWeather.createJSON();
                }
            }
        }
        System.out.println("Dzięki do zobaczenia");
    }
}