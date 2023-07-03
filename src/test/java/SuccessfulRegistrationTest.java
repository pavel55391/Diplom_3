import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.SuccessfulTegistrationPageObject;

public class SuccessfulRegistrationTest {
    private WebDriver driver;
    private SuccessfulTegistrationPageObject successfulTegistrationPageObject;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        successfulTegistrationPageObject = new SuccessfulTegistrationPageObject(driver);
    }

    @Test
    @Description("Log out of your account")
    public void checkSuccessfulRegistrationTest() {
        String actual = successfulTegistrationPageObject.checkSuccessfulRegistration();
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", actual);
    }

    @Test
    @Description("Checking error for incorrect password")
    public void checkErrorForIncorrectPassword() {
        String actual = successfulTegistrationPageObject.errorForIncorrectPassword();
        Assert.assertEquals("Некорректный пароль", actual);
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
