import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    private static final By BUN = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private static final By SAUSES = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private static final By FILLINGS = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");

    @Test
    public void switchingBetweenSection() {
        Assert.assertTrue(driver.findElement(BUN).isEnabled());
        driver.findElement(SAUSES).click();
        Assert.assertTrue(driver.findElement(SAUSES).isEnabled());
        driver.findElement(FILLINGS).click();
        Assert.assertTrue(driver.findElement(FILLINGS).isEnabled());
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
