package org.WeatherReports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeteoConfig {

    static File myConfig;
    static Scanner myReader;

    static String getAppId() {
        String buffer = "";
        try {
            myConfig = new File("C:\\Users\\Witek\\IdeaProjects\\WeatherReports\\src\\main\\resources\\meteo.conf");
            myReader = new Scanner(myConfig);
            while (myReader.hasNextLine()) {
                buffer = myReader.nextLine();
                System.out.println(buffer);
            }
            return buffer;
            //myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return buffer;
    }
}
