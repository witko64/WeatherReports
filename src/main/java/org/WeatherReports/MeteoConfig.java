package org.WeatherReports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeteoConfig {

    static File myConfig;
    static Scanner myReader;
    public static String appID;
    public static String restURL;
    public static String path;

    public void ReadMeteoConfig() {
        try {
            myConfig = new File("C:\\Users\\Witek\\IdeaProjects\\WeatherReports\\src\\main\\resources\\meteo.conf");
            myReader = new Scanner(myConfig);
            if (myReader.hasNextLine()) {
                restURL = myReader.nextLine();
                System.out.println(restURL);
            }
            if (myReader.hasNextLine()) {
                appID = myReader.nextLine();
                System.out.println(appID);
            }
            if (myReader.hasNextLine()) {
                path = myReader.nextLine();
                System.out.println(path);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
