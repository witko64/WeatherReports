package org.WeatherReports;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Meteo {

//    protected static String PATH_TO_JSON = "c:\\cities.json";

    public static void main(String[] args) throws IOException {
//  Variables
        CityList cityList = new CityList();
        City city;
        boolean goOn = true;
        Scanner scanner = new Scanner(System.in);
        String cmd;
        String myCity;
        String saveAs;
        MeteoConfig meteoConfig = new MeteoConfig();
        Weather weather = new Weather();

        while (goOn) {
            System.out.println("P-podaj miasto, Z-zakończ");
            cmd = scanner.nextLine().toUpperCase();
            if (!cmd.isEmpty()) {
                if (cmd.charAt(0) == 'Z') {
                    goOn = false;
                }
                else if (cmd.charAt(0) == 'P') {
                    cityList.printCities();
                    System.out.println("Podaj nazwę miasta");
                    myCity = scanner.nextLine();
                    city = cityList.getCity(myCity);
                    if (city==null) {
                        System.out.println("Nie znalazłem :"+myCity);
                    }
                    else {
                        weather.getWeather(city);
                        weather.writeWeatherReport();
                        System.out.println("\nP-PDF J-JSON X-XML");
                        saveAs = scanner.nextLine().toUpperCase();
                        if (!saveAs.isEmpty()) {
                            switch (saveAs) {
                                case "P":
                                    weather.createPDF();

                                case "J":
                                    weather.createJSON();

                                case "X":
                                    weather.createXML();

                                default:
                                    System.out.println("\n");
                                    break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Dzięki do zobaczenia");
    }
}