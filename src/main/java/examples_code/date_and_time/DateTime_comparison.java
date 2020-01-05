package examples_code.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTime_comparison {
    public static void main(String[] args) {

        // dates/time comparison
        LocalDate now = LocalDate.now();
        LocalDate theOtherDay = LocalDate.of(2019, 4, 27);
        boolean after1 = now.isAfter(theOtherDay); // true
        boolean before1 = now.isBefore(theOtherDay); // false

        LocalTime nowTime = LocalTime.now();
        LocalTime once = nowTime.plusHours(4);
        boolean after2 = nowTime.isAfter(once); // false
        boolean before2 = nowTime.isBefore(once); // true

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime twoMonthAgo = dateTimeNow.minusMonths(2);
        boolean after3 = dateTimeNow.isAfter(twoMonthAgo); // true
        boolean before3 = dateTimeNow.isBefore(twoMonthAgo); // false

        // similar to isAfter() and isBefore:
        int after4 = dateTimeNow.compareTo(twoMonthAgo); // 1
        int before4 = twoMonthAgo.compareTo(dateTimeNow); // -1
    }
}
