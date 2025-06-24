package org.WeatherReports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Date;

import static org.apache.http.util.EntityUtils.consume;

public class Weather {

    public CurrentWeather currentWeather;
    private String weatherJsonString = "";

    public Weather() {
    }
    private void checkWeatherData() {
        if (currentWeather.dt == null) {
            currentWeather.dt = 0L;
        }
        if (currentWeather.name == null) {
            currentWeather.name = "nierozpoznana miejscowość";
        }
        if (currentWeather.main.pressure == null) {
            currentWeather.main.pressure = 0L;
        }
        if (currentWeather.main.temp == null) {
            currentWeather.main.temp = 0L;
        }
        if (currentWeather.main.feels_like == null) {
            currentWeather.main.feels_like = 0L;
        }
        if (currentWeather.wind.speed == null) {
            currentWeather.wind.speed = 0.0;
        }
        if (currentWeather.wind.gust == null) {
            currentWeather.wind.gust = 0.0;
        }
        if (currentWeather.visibility == null) {
            currentWeather.visibility = 0.0;
        }
    }

    private String setRestCmd(Coord coord) {
       return MeteoConfig.restURL + "lat=" + coord.lat + "&lon=" + coord.lon + "&" + MeteoConfig.defaultUnits +"&"+MeteoConfig.defaultLang + "&appid=" + MeteoConfig.appID;
    }

    public void getWeather(City city) {
        String restCMD = setRestCmd(city.coord);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(restCMD);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            weatherJsonString = EntityUtils.toString(entity);
            consume(entity);
            ObjectMapper om = new ObjectMapper();
            try {
                // covert JSON string to list Java object
                currentWeather = om.readValue(weatherJsonString, CurrentWeather.class);
                checkWeatherData();
            } catch (JsonProcessingException e) {
                System.out.println("Błąd przetwarzania prognozy pogody JSON -> obiekt");
            }
        } catch (IOException e) {
            System.out.println("Błąd obsługi żądania rest");
        }
    }

    public void writeWeatherReport() {
        //Date date =  new Date((currentWeather.dt+currentWeather.timezone)*1000);
        Date date =  new Date(currentWeather.dt*1000);
        System.out.println("Prognoza pogody data:" + date +" miejscowość  " + currentWeather.name);
        System.out.println("Ciśnienie atmosferyczne: "+ currentWeather.main.pressure.toString() +"hPa");
        System.out.println("Temperatura: " + currentWeather.main.temp.toString() + "C  odczuwalna " + currentWeather.main.feels_like.toString()+"C");
        System.out.println("Wiatr z kierunku: " + currentWeather.wind.getWindDirectionString()  +" "+ currentWeather.wind.speed.toString() + "m/s w porywach "+currentWeather.wind.gust.toString() + "m/s");
        System.out.println("Widzialność: " + currentWeather.visibility.toString()+" metrów");
    }

    public void createPDF() {
        try {
            Date date =  new Date((currentWeather.dt+currentWeather.timezone)*1000);
            Document document = new Document();
            File file = new File(currentWeather.name + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            Font f = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED,8);
            //Font f = FontFactory.getFont("Arial", "UTF-8", Font.NORMAL);

            f.setStyle(Font.BOLD);
            f.setSize(16);
            Paragraph p = new Paragraph();
            p.setFont(f);
            p.add("Prognoza pogody data: " + date +" miejscowość  " + currentWeather.name+"\n");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            f.setStyle(Font.ITALIC);
            f.setSize(12);
            Paragraph p2 = new Paragraph();
            p2.setFont(f);
            p2.add("Ciśnienie atmosferyczne: "+ currentWeather.main.pressure.toString() +"hPa\n" +
            "Temperatura: " + currentWeather.main.temp.toString() + "C  odczuwalna " + currentWeather.main.feels_like.toString()+"C\n" +
            "Wiatr z kierunku: " + currentWeather.wind.getWindDirectionString() +" "+ currentWeather.wind.speed.toString() + "m/s w porywach "+currentWeather.wind.gust.toString() + "m/s\n" +
            "Widzialność: " + currentWeather.visibility.toString()+" metrów\n");

            document.add(p2);
            document.close();
            System.out.println("OK, utworzono plik " + currentWeather.name+".pdf");
        } catch (DocumentException | IOException e) {
            System.out.println("Błąd tworzenia pliku PDF.");
        }
    }

    public void createXML() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            File xmlFile = new File(currentWeather.name + ".xml");
            xmlMapper.writeValue(xmlFile, currentWeather);
            System.out.println("OK, utworzono plik "+currentWeather.name+".xml");
        } catch (IOException e) {
            System.out.println("Błąd tworzenia pliku XML.");
        }
    }

    public void createJSON(){
        try {
            FileWriter writer = new FileWriter(currentWeather.name + ".json");
            writer.write(weatherJsonString);
            writer.close();
            System.out.println("OK, utworzono plik "+ currentWeather.name + ".json");
        } catch (IOException e) {
            System.out.println("Błąd zapisu JSON.");
        }
    }
}
