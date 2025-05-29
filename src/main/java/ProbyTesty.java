import org.w3c.dom.CDATASection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProbyTesty {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2025-05-29");
        System.out.println(date);
        String dateInString = "19590709";
        date = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);
        String st = "{\"coord\":{\"lon\":10.99,\"lat\":44.34},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":295.05,\"feels_like\":294.81,\"temp_min\":294.86,\"temp_max\":295.52,\"pressure\":1016,\"humidity\":58,\"sea_level\":1016,\"grnd_level\":949},\"visibility\":10000,\"wind\":{\"speed\":1.5,\"deg\":145,\"gust\":1.58},\"clouds\":{\"all\":72},\"dt\":1747663251,\"sys\":{\"type\":2,\"id\":2004688,\"country\":\"IT\",\"sunrise\":1747626297,\"sunset\":1747680020},\"timezone\":7200,\"id\":3163858,\"name\":\"Zocca\",\"cod\":200} ";
        String[] tablica = st.split(":"); //
        System.out.println(tablica);
    }
}
