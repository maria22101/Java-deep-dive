package examples_code.date_and_time;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class ZonedDateTime_examples {
    public static void main(String[] args) {

        // ZonedDateTime contains simply LocalDateTime & ZoneId
        // ZonedDateTime creation options:
        ZonedDateTime now = ZonedDateTime.now(); // 2020-01-05T20:05:41.931+02:00[Europe/Helsinki]

        LocalDate localDate = LocalDate.of(2020, 1, 5);
        LocalTime localTime = LocalTime.of(20, 6);
        ZoneId zone = ZoneId.of("Europe/Kiev");
        ZonedDateTime myCurrent = ZonedDateTime.of(localDate, localTime, zone); // 2020-01-05T20:06+02:00[Europe/Kiev]

        // Convert ZoneId between zones:
        ZonedDateTime nyTime = myCurrent.withZoneSameInstant(ZoneId.of("America/New_York"));
        //2020-01-05T13:06-05:00[America/New_York]
        ZonedDateTime japanTime = myCurrent.withZoneSameInstant(ZoneOffset.of("-09:00"));
        //2020-01-05T09:06-09:00

        // Get all time zones:
        List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        zones.forEach(System.out::println);
    }
}
