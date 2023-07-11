import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.Driver;
import ru.practicum.yandex.pageobject.LogOutPageObject;


public class LogOutTest {
    private WebDriver driver;
    private LogOutPageObject logOutPageObject;

    @Before
    public void setUp() {
        Driver driver = new Driver();
        this.driver = driver.getDriver();
        logOutPageObject = new LogOutPageObject(this.driver);
    }

    @Test
    @Description("Log out of your account")
    public void logOut() {
        String actual = logOutPageObject.logOut();
        Assert.assertEquals("Войти" , actual);
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }

}
