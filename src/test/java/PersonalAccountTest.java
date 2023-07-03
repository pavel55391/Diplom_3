import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.PersonalAccountPageObject;

public class PersonalAccountTest {
    private WebDriver driver;
    private PersonalAccountPageObject personalAccountPageObject;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        personalAccountPageObject = new PersonalAccountPageObject(driver);
    }

    @Test
    @Description("Transfer to your personal account")
    public void transitionToPersonalAccount(){
        String actual = personalAccountPageObject.transferToPersonalAccount();
        Assert.assertEquals("Войти", actual);
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
