import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.practicum.yandex.pageobject.Driver;
import ru.practicum.yandex.pageobject.LogInPageObject;


public class LogInTest {
    private WebDriver driver;
    private LogInPageObject logInPageObject;

    @Before
    public void setUp(){
        Driver driver = new Driver();
        this.driver = driver.getDriver();
        logInPageObject = new LogInPageObject(this.driver);
    }

    @Test
    @Description("Login via the main page")
    public void logInMainPage(){
        String actual = logInPageObject.successfulLogging();
        String expected = "В этом разделе вы можете изменить свои персональные данные";
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Description("Login via your Personal Account")
    public void logInPersonalAccount(){
        String actual = logInPageObject.loginInAccount();
        String expected = "В этом разделе вы можете изменить свои персональные данные";
        Assert.assertEquals(expected, actual);
    }


    @Test
    @Description("Login via the button in the registration form")
    public void logInViaRegistrationForm(){
        String actual = logInPageObject.loginViaRegistration();
        String expected = "В этом разделе вы можете изменить свои персональные данные";
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Description("Login via the button in the password recovery form")
    public void logInViaPasswordRecoveryForm(){
        String actual = logInPageObject.loginViaPasswordRecovery();
        String expected = "В этом разделе вы можете изменить свои персональные данные";
        Assert.assertEquals(expected , actual);
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
