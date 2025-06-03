package org.WeatherReports;

public class JWind {
    public JWind() {
    }
    public Double speed; //Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
    public int deg; //Wind direction, degrees (meteorological)
    public Double gust; //Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour

    public int SetWindDirection(){
        return deg / 45;
    }

    public String SetWindDirectionString () {
        if (deg <=22 || deg >=338 ) {
            return "N - północny";
        } else if (deg >=23 && deg <= 68 ) {
            return "NE - północno wschodni";
        } else if (deg >=69 && deg <= 112 ) {
            return "E - wschodni";
        }
        else if (deg >= 113 && deg <= 158 ) {
            return "SE - południowo wschodni";
        }
        else if (deg >159 && deg <= 202 ) {
            return "S - południowy";
        }
        else if (deg >=202 && deg <= 255 ) {
            return "SW - południowo zachodni";
        }
        else if (deg >=255 && deg <= 292 ) {
            return "W - zachodni";
        }
        else if (deg >=292 && deg <= 337 ) {
            return "NW - pólnocno zachodni";
        }
        else {return "N - północny";}
    }


}
