package examples_code.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTime_formatting {
    public static void main(String[] args) {

        // formatting into a string:
        LocalDate now = LocalDate.now();
        String date = now.format(DateTimeFormatter.ISO_DATE); // 2020-01-05
        String customizedDate = now.format(DateTimeFormatter.ofPattern("dd MMM yyyy")); // 05 Jan 2020
        String germanDate = now.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRANCE)); // 05 janv. 2020

        LocalTime nowTime = LocalTime.now();
        String time = nowTime.format(DateTimeFormatter.ISO_LOCAL_TIME); // 19:57:15.773
        String customizedTime1 = nowTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")); // 07:57:15
        String customizedTime2 = nowTime.format(DateTimeFormatter.ofPattern("h:mm a")); // 7:58 PM

        LocalDateTime dateTimeNow = LocalDateTime.now();
        String dateTimeStr = dateTimeNow.format(DateTimeFormatter.ISO_DATE_TIME); // 2020-01-05T20:02:21.664
        String customizedDateTime = dateTimeNow.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss"));
        // Sun, 05 Jan 2020 08:02:21
    }
}
