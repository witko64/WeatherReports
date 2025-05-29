package org.WeatherReports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
                currentWeather = om.readValue(weatherJsonString, CurrentWeather.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeWeatherReport() {
        System.out.println("");
        System.out.println("Prognoza pogody data:" + currentWeather.dt.toString() +" miejscowość  " + currentWeather.name);
        System.out.println("Ciśnienie atmosferyczne: "+ currentWeather.main.pressure.toString() +"hPa");
        System.out.println("Temperatura: " + currentWeather.main.temp.toString() + "C  odczuwalna " + currentWeather.main.feels_like.toString()+"C");
        System.out.println("Wiatr z kierunku: " + currentWeather.wind.deg +" "+ currentWeather.wind.speed.toString() + "m/s w porywach "+currentWeather.wind.gust.toString() + "m/s");
        System.out.println("Widzialność: " + currentWeather);
    }
    public void createPDF() {
        System.out.println("createPDF");
    }

    public void createXML() throws JsonProcessingException {
        System.out.println("createXML");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(currentWeather);
        System.out.println(xml);
        try {
            File xmlFile = new File(currentWeather.name + ".xml");
            xmlMapper.writeValue(xmlFile, currentWeather);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void createJSON(){
        System.out.println("createJSON");
    }
}
