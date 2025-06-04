package org.WeatherReports;

public class JWind {

    public JWind() {
    }

    public Double speed; //Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    public int deg; //Wind direction, degrees (meteorological)
    public Double gust; //Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    private final String[] windDir = {"N", "NbE", "NNE", "NEbN", "NE", "NEbE", "ENE", "EbN",
            "E", "EbS", "ESE", "SEbE", "SE", "SEbS", "SSE", "SbE",
            "S", "SbW", "SSW", "SWbS", "SW", "SWbW", "WSW", "WbS",
            "W", "WbN", "WNW", "NWbW", "NW", "WNbNE", "NNW", "NbW", "N"};

    public int getWindDirection(){
        return (int) (deg / 11.25);
    }

    public String getWindDirectionString () {
        return windDir[getWindDirection()];
    }
}
