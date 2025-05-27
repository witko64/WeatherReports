package org.WeatherReports;

public class CurrentWeather {

    public CurrentWeather() {
    }

    JCoord jCoord;
    JWeather[] jWeather;
    String jBbase; //Weather icon id
    JMainParameters jMainParameters;
    Double visibility; //Visibility, meter. The maximum value of the visibility is 10 km
    JWind jWind;
    JClouds jClouds;
    JRain jRain;
    JSnow jSnow;
    Long dt; // Time of data calculation, unix, UTC
    JSys jSys;
    int timezone; //Shift in seconds from UTC
    int id; //City ID. Please note that built-in geocoder functionality has been deprecated. Learn more here
    String name; //City name. Please note that built-in geocoder functionality has been deprecated. Learn more here
    int cod; //Internal parameter

    public class JCoord {
       Long lon; //Longitude of the location
       Long lat; //Latitude of the location
    }
    public class JWeather { //(more info Weather condition codes)
        Long id; //Weather condition id
        String main; //Group of weather parameters (Rain, Snow, Clouds etc.)
        String description; //Weather condition within the group. Please find more here. You can get the output in your language. Learn more
        String icon; //Weather icon id
    }

    public class JMainParameters {
        Long temp;  // Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        Long feels_like; //Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        Long pressure; //Atmospheric pressure on the sea level, hPa
        Long humidity; //Humidity, %
        Long temp_min; //Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        Long temp_max; //Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Please find more info here. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit
        Double sea_level; //Atmospheric pressure on the sea level, hPa
        Double grnd_level; //Atmospheric pressure on the ground level, hPa
    }

    public class JWind {
        Double speed; //Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
        int deg; //Wind direction, degrees (meteorological)
        Double gust; //Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    }
    public class JClouds {
        int all; //Cloudiness, %
    }

    public class JRain {
        double l1; //1h(where available)Precipitation, mm/h. Please note that only mm/h as units of measurement are available for this parameter
    }

    public class JSnow {
        double l1; //1h(where available) Precipitation, mm/h. Please note that only mm/h as units of measurement are available for this parameter
    }

    public class JSys {
        int type; //Internal parameter
        int id; //Internal parameter
        String message; //Internal parameter
        String country; //Country code (GB, JP etc.)
        Long sunrise; //Sunrise time, unix, UTC
        Long sunset; //time, unix, UTC
    }
}
