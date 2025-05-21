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

import static org.apache.http.util.EntityUtils.*;

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

    public void getWeather(String token) throws IOException {
        String restPATH = "https://api.openweathermap.org/data/2.5/weather?";
        String restCMD = restPATH + token + "lat=54.52&lon=18.55&units=metric&lang=pl&appid="; //appid token przekazywany jako prametr main()
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(restCMD);
        try (CloseableHttpResponse response = httpClient.execute(request)){
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);
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
