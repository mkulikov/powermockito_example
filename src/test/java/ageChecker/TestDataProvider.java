package ageChecker;

import org.testng.annotations.DataProvider;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestDataProvider {

    @DataProvider(name = "AgeChecker")
    public static Object[][] data() {
        return new Object[][] {
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(1999, Calendar.JULY, 18),
                        true
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2001, Calendar.JUNE, 18),
                        true
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2001, Calendar.JULY, 17),
                        true
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2009, Calendar.JULY, 18),
                        false
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2001, Calendar.AUGUST, 18),
                        false
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2001, Calendar.JULY, 19),
                        false
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 17, 23, 59, 59),
                        new GregorianCalendar(2001, Calendar.JULY, 18),
                        false
                },
                {
                        new GregorianCalendar(2019, Calendar.JULY, 18),
                        new GregorianCalendar(2001, Calendar.JULY, 18, 23, 59, 59),
                        true
                }
        };
    }
}
