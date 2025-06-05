package org.WeatherReports;

import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TestTime {
    public static void main(String[] args) {
        String myStringTime = "12:30:10";
        long myLongDateAndTime = 1749117132L + 7200L;

        LocalTime time = LocalTime.parse(myStringTime);


        System.out.println(time);

        Instant instant = Instant.ofEpochMilli(myLongDateAndTime);
        System.out.println(instant);

        OffsetDateTime odt = instant.atOffset(ZoneOffset.of("-04:00"));
        System.out.println(odt);

        odt = odt.with(time);
        System.out.println(odt);
    }
}