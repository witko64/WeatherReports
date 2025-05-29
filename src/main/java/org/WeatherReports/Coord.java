package org.WeatherReports;

public class Coord {
    double lon=0.0;
    double lat=0.0;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Coord() {
        this.lon = 0.0;
        this.lat = 0.0;
    }
}

