import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.LogOutPageObject;


public class LogOutTest {
    private WebDriver driver;
    private LogOutPageObject logOutPageObject;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        logOutPageObject = new LogOutPageObject(driver);
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
