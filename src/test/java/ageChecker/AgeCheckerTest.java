package ageChecker;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Calendar;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@PrepareForTest({AgeChecker.class})
public class AgeCheckerTest {

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    @Test(testName = "Test", alwaysRun = true, dataProviderClass = TestDataProvider.class, dataProvider = "AgeChecker")
    public void test(Calendar now, Calendar birthday, boolean check) {
        Clock clock = Clock.fixed(now.toInstant(), ZonedDateTime.now().getOffset());
        ZonedDateTime date = ZonedDateTime.now(clock);
        mockStatic(ZonedDateTime.class);
        when(ZonedDateTime.now()).thenReturn(date);
        Assert.assertEquals(AgeChecker.check(birthday), check);
    }

}
