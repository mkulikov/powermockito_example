package ageChecker;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@PrepareForTest({AgeChecker.class})
public class AgeCheckerTest {

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    @DataProvider(name = "AgeChecker")
    public static Object[][] data() {
        return new Object[][]{
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

    @Test(testName = "Test", alwaysRun = true, dataProvider = "AgeChecker")
    public void test(Calendar now, Calendar birthday, boolean check) {
        Clock clock = Clock.fixed(now.toInstant(), ZonedDateTime.now().getOffset());
        ZonedDateTime date = ZonedDateTime.now(clock);
        mockStatic(ZonedDateTime.class);
        when(ZonedDateTime.now()).thenReturn(date);
        Assert.assertEquals(AgeChecker.check(birthday), check);
    }

}
