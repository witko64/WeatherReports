package org.WeatherReports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.internal.icu.text.UCharacterIterator;
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
import java.util.Iterator;
import java.util.List;

import static org.apache.http.util.EntityUtils.*;

public class Weather {

    CurrentWeather currentWeather;
    String weatherJsonString = "";

    public Weather() {
    }

    public void getWeather(City city) throws IOException {

        String restCMD = MeteoConfig.restURL + "lat=" + Double.toString(city.coord.lat) + "&lon=" + Double.toString(city.coord.lon) + "&" + MeteoConfig.defaultUnits +"&"+MeteoConfig.defaultLang + "&appid=" + MeteoConfig.appID;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(restCMD);

        try (CloseableHttpResponse response = httpClient.execute(request)){
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            InputStream myStream = entity.getContent();
            weatherJsonString = EntityUtils.toString(entity);     // return it as a String
            consume(entity);

            ObjectMapper om = new ObjectMapper();
            try {
                // covert JSON string to list Java object
                System.out.println(weatherJsonString); //usunac
                currentWeather = om.readValue(weatherJsonString, CurrentWeather.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createWeatherReport() {
        System.out.println("getWeatherReport");

        System.out.println(currentWeather);
    }
    public void createPDF(String city) {
        System.out.println("createPDF");
    }

    public void createXML(){
        System.out.println("createXML");
    }
    public void createJSON(){
        System.out.println("createJSON");
    }
}
