package examples_code.date_and_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Period_and_Duration_examples {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now(); // 2020-01-05
        Period period = Period.of(1, 0, 2);
        LocalDate newDate = now.plus(period); // 2021-01-07

        LocalTime nowTime = LocalTime.now(); // 20:40:08.811
        LocalTime newTime = LocalTime.of(22, 35); // 22:35
        Duration duration1 = Duration.between(nowTime, newTime);
        long minutesBetween = duration1.toMinutes(); // 114

        LocalDate myNextBirthday = LocalDate.of(2020, 10, 22);

        // conversion to the LocalDateTime required as Duration does not work with LocalDate
        Duration duration2 = Duration.between(now.atStartOfDay(), myNextBirthday.atStartOfDay());
        long daysToMyBirthDay1 = duration2.toDays(); // 291
        long daysToMyBirthDay2 = ChronoUnit.DAYS.between(now, myNextBirthday); // 291
    }
}
