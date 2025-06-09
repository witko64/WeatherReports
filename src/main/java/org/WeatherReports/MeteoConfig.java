package org.WeatherReports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeteoConfig {
// Global parameters
    public static String appID;
    public static String restURL;
    public static String defaultPath;
    public static String defaultLang;
    public static String defaultUnits;


    static File myConfig;
    static Scanner myReader;

    public MeteoConfig() {
        ReadMeteoConfig();
    }

    public void ReadMeteoConfig() {
        try {
            myConfig = new File(System.getenv("HOMEPATH") + "\\IdeaProjects\\WeatherReports\\src\\main\\resources\\meteo.conf"); //target ??
            myReader = new Scanner(myConfig);
            if (myReader.hasNextLine()) {
                restURL = myReader.nextLine();
            }
            if (myReader.hasNextLine()) {
                appID = myReader.nextLine();
            }
            if (myReader.hasNextLine()) {
                defaultPath = myReader.nextLine();
            }
            if (myReader.hasNextLine()) {
                defaultLang = myReader.nextLine();
            }
            if (myReader.hasNextLine()) {
                defaultUnits = myReader.nextLine();
            }}
        catch (FileNotFoundException e) {
            System.out.println("Błąd otwarcia lub odczytu konfiguracji.");
        }
    }
}
