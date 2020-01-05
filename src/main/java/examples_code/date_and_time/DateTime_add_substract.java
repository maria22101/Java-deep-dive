package examples_code.date_and_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime_add_substract {
    public static void main(String[] args) {

        // while adding/substracting the defined periods new instances of the LocalDate are created
        // as the LocalDate class is immutable
        LocalDate now = LocalDate.now();
        LocalDate plus2days = now.plusDays(2);
        LocalDate plus3weeks = now.plusWeeks(3);
        LocalDate plus4months = now.plusMonths(4);
        LocalDate plusPeriod = now.plus(Period.ofYears(1));
        LocalDate plusMillennia = now.plus(2, ChronoUnit.MILLENNIA);

        LocalDate minus2days = now.minusDays(2);
        LocalDate minus3weeks = now.minusWeeks(3);
        LocalDate minus4months = now.minusMonths(4);
        LocalDate minusPeriod = now.minus(Period.ofYears(1));
        LocalDate minusCentury = now.plus(1, ChronoUnit.CENTURIES);

        LocalTime timeNow = LocalTime.now();
        LocalTime plusNanos = timeNow.plusNanos(100_000);
        LocalTime plusSeconds = timeNow.plusSeconds(89);
        LocalTime plusMinutes = timeNow.plusMinutes(15);
        LocalTime plusHours = timeNow.plusHours(5);
        LocalTime plusDuration = timeNow.plus(Duration.ofMillis(1000));
        LocalTime plusHalfDays = timeNow.plus(2, ChronoUnit.HALF_DAYS);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime plusDay = dateTimeNow.plusDays(1);
        LocalDateTime plus2Years = dateTimeNow.plusYears(2);
        LocalDateTime plus3Centuries = dateTimeNow.plus(3, ChronoUnit.CENTURIES);
    }
}
