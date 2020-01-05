package examples_code.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTime_setup {
    public static void main(String[] args) {

        // static method now() allows to get current local date or time (not defined by any timezone):
        LocalDate date1 = LocalDate.now();
        LocalTime time1 = LocalTime.now();
        LocalDateTime dateTime1 = LocalDateTime.now();

        // static method of(), ofYearDay(), ofSecondOfDay(), ofNanoOfDay()
        // - sets the stated date or time (not defined by any timezone):
        LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 7);
        LocalDate date3 = LocalDate.of(2020, 1, 7);
        LocalDate date4 = LocalDate.ofEpochDay(18353L);

        LocalTime time2 = LocalTime.of(18, 55);
        LocalTime time3 = LocalTime.of(18, 55, 54);
        LocalTime time4 = LocalTime.ofSecondOfDay(9_124);
        LocalTime time5 = LocalTime.ofNanoOfDay(100_000_000_000L);

        LocalDateTime dateTime2 = LocalDateTime.of(1998, Month.AUGUST, 25, 16, 20);
        LocalDateTime dateTime3 = LocalDateTime.of(1999, 9, 20, 9, 30, 45);
        LocalDateTime dateTime4 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    }
}