//Klasa CurrentWeather - odwzorownie API https://openweathermap.org/current

package org.WeatherReports;

import java.util.Date;

public class CurrentWeather {

    public CurrentWeather() {
    }

    public Coord coord = new Coord();
    public WeatherDescription[] weather;
    public String base; //Weather icon id
    public WeatherMainParameters main;
    public Double visibility; //Visibility, meter. The maximum value of the visibility is 10 km
    public Wind wind;
    public Clouds clouds;
    public Rain rain;
    public Snow snow;
    public Long dt; // Time of data calculation, unix, UTC
    public SysParameters sys;
    public int timezone; //Shift in seconds from UTC
    public int id; //City ID. Please note that built-in geocoder functionality has been deprecated. Learn more here
    public String name; //City name. Please note that built-in geocoder functionality has been deprecated. Learn more here
    public int cod; //Internal parameter

    public static class WeatherDescription { //(more info Weather condition codes)
        public Long id; //Weather condition id
        public String main; //Group of weather parameters (Rain, Snow, Clouds etc.)
        public String description; //Weather condition within the group. Please find more here. You can get the output in your language. Learn more
        public String icon; //Weather icon id
    }

    public static class WeatherMainParameters {
        public Long temp;  // Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        public Long feels_like; //Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        public Long pressure; //Atmospheric pressure on the sea level, hPa
        public Long humidity; //Humidity, %
        public Long temp_min; //Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        public Long temp_max; //Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        public Double sea_level; //Atmospheric pressure on the sea level, hPa
        public Double grnd_level; //Atmospheric pressure on the ground level, hPa
    }

    public static class Clouds {
        public int all; //Cloudiness, %
    }

    public static class Rain {
        public double l1; //1h(where available)Precipitation, mm/h. Please note that only mm/h as units of measurement are available for this parameter
    }

    public static class Snow {
        public double l1; //1h(where available) Precipitation, mm/h. Please note that only mm/h as units of measurement are available for this parameter
    }

    public static class SysParameters {
        public int type; //Internal parameter
        public int id; //Internal parameter
        public String message; //Internal parameter
        public String country; //Country code (GB, JP etc.)
        public Date sunrise; //Sunrise time, unix, UTC
        public Date sunset; //time, unix, UTC
    }
}
