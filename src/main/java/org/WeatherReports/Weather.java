package org.WeatherReports;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Weather {
    String Name;
    float latitude;
    float longitude;
    float temperature;
    float windSpeed;
    int windDirection;

    public Weather(String name, float latitude, float longitude) {
        Name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void getWeather() throws IOException {
        String restPATH = "https://api.openweathermap.org/data/2.5/weather?";
        String restCMD = restPATH + "lat=54.52&lon=18.55&units=metric&lang=pl&&appid=1dc17e8ab126fde44f63fa0f671b141d";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(restCMD);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)){
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);
            EntityUtils.consume(entity);
        } finally {
            response.close();
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
