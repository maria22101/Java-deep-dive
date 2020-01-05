package examples_code.date_and_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjuster_examples {
    public static void main(String[] args) {

        // date of the 2nd Sunday in the current month
        LocalDate now = LocalDate.now(); // 2020-01-05
        TemporalAdjuster secondSunday = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY);
        LocalDate dateOfSecondSunday = now.with(secondSunday); // 2020-01-12

        // date of the first Monday in February 2020:
        LocalDate localDate = LocalDate.of(2020, 2, 1);
        TemporalAdjuster firstMonday = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate dateOfFirstMondayInFebruary = localDate.with(firstMonday); // 2020-02-03

        // how many days left till the last Friday in January 2020
        TemporalAdjuster lastFriday = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
        LocalDate dateOfLastFridayInJanuary = now.with(lastFriday);
        Period until = now.until(dateOfLastFridayInJanuary);
        int daysToLastFridayInJanuary = until.getDays(); // 26

        // what date will be on the next Tuesday?
        TemporalAdjuster nextTue = TemporalAdjusters.next(DayOfWeek.TUESDAY);
        LocalDate dateOfNextTuesday = now.with(nextTue); // 2020-01-07

        // what date was on the last Wednesday?
        TemporalAdjuster lastWed = TemporalAdjusters.previous(DayOfWeek.WEDNESDAY);
        LocalDate dateOfLastWed = now.with(lastWed); // 2020-01-01
    }
}
