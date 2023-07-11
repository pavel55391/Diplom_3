import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.Driver;
import ru.practicum.yandex.pageobject.PersonalAccountPageObject;

public class PersonalAccountTest {
    private WebDriver driver;
    private PersonalAccountPageObject personalAccountPageObject;

    @Before
    public void setUp(){
        Driver driver = new Driver();
        this.driver = driver.getDriver();
        this.driver.get("https://stellarburgers.nomoreparties.site");
        personalAccountPageObject = new PersonalAccountPageObject(this.driver);
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
