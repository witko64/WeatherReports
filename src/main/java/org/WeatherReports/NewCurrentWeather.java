package org.WeatherReports;

import java.util.Date;

public class NewCurrentWeather {

    public NewCurrentWeather() {
    }

    public JWeather[] weather;
    public Long temp;  // Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
    public Long feelLike; //Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
    public Long pressure; //Atmospheric pressure on the sea level, hPa
    public Long humidity; //Humidity, %
    public Long tempMin; //Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
    public Long tempMax; //Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
    public Double seaLevel; //Atmospheric pressure on the sea level, hPa
    public Double grndLevel; //Atmospheric pressure on the ground level, hPa
    public Double visibility; //Visibility, meter. The maximum value of the visibility is 10 km
    public Double windSpeed; //Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    public int windDeg; //Wind direction, degrees (meteorological)
    public Double windGust; //Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    public int clouds; //Cloudiness, %
    public int rain;
    public int snow;
    public Long dt; // Time of data calculation, unix, UTC
    public int timezone; //Shift in seconds from UTC
    public String name; //City name. Please note that built-in geocoder functionality has been deprecated. Learn more here


    public static class JWeather { //(more info Weather condition codes)
        public Long id; //Weather condition id
        public String main; //Group of weather parameters (Rain, Snow, Clouds etc.)
        public String description; //Weather condition within the group. Please find more here. You can get the output in your language. Learn more
    }

}
