import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.SwitchFromPersonalAccountToConstructorPageObject;


public class SwitchFromPersonalAccountToConstructorTest {
    private WebDriver driver;
    private SwitchFromPersonalAccountToConstructorPageObject switchFromPersonalAccountToConstructorPageObject;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        switchFromPersonalAccountToConstructorPageObject = new SwitchFromPersonalAccountToConstructorPageObject(driver);
    }

    private static final By CONSTRUCTOR_IS_ENABLED = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");

    @Test
    @Description("Switching from your personal account to the constructor")
    public void clickToTheConstructorFromPersonalAccount(){
        switchFromPersonalAccountToConstructorPageObject.switchingFromPersonalAccount();
        Assert.assertTrue(driver.findElement(CONSTRUCTOR_IS_ENABLED).isEnabled());

    }

    @Test
    @Description("Switching from the personal account to the constructor via the logo")
    public void clickToTheLogo(){
        switchFromPersonalAccountToConstructorPageObject.switchingFromPersonalAccountViaLogo();
        Assert.assertTrue(driver.findElement(CONSTRUCTOR_IS_ENABLED).isEnabled());

    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
