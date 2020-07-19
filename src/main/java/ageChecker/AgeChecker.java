package ageChecker;

import java.time.ZonedDateTime;
import java.util.Calendar;


public class AgeChecker {

    private AgeChecker() {
    }

    public static boolean check(Calendar calendar) {

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        calendar.add(Calendar.YEAR, 18);

        return ZonedDateTime.now().toEpochSecond() >= calendar.getTime().getTime() / 1000;
    }

}