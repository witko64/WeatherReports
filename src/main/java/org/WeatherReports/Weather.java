package org.WeatherReports;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.http.util.EntityUtils.*;

public class Weather {
    String Name;
    double longitude;
    double latitude;
    double temperature;
    double windSpeed;
    int windDirection;
    String weatherJsonString;
    public Weather(String name, double longitude, double latitude) {
        Name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Weather() {
    }

    public void getWeather() throws IOException {
        String restCMD = MeteoConfig.restURL + "lat=" + Double.toString(latitude) + "&lon=" + Double.toString(longitude) + "&" + MeteoConfig.defaultUnits +"&"+MeteoConfig.defaultLang + "&appid=" + MeteoConfig.appID;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(restCMD);
        try (CloseableHttpResponse response = httpClient.execute(request)){
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            InputStream myStream = entity.getContent();
            weatherJsonString = EntityUtils.toString(entity);     // return it as a String
            consume(entity);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getWeatherReport() {
        System.out.println("getWeatherReport");
    }
    public void createPDF() {
        System.out.println("createPDF");
    }

    public void createXML(){
        System.out.println("createXML");
    }
    public void createJSON(){
        System.out.println("createJSON");
    }
}
