package ru.practicum.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogInPageObject {

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By LOGIN_BUTTON_MAIN_PAGE = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By EMAIL_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By REGISTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private static final By COME_IN = By.className("Auth_link__1fOlj");
    private static final By RECOVER_PASSWORD_BUTTON = By.className("Auth_link__1fOlj");
    private static final By EXPECTED_RESULT_TEXT = By.xpath("//*[@id=\"root\"]/div/main/div/nav/p");


    private WebDriver driver;

    public LogInPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(REGISTRATION_URL);
    }

    public String successfulLogging() {
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();
        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        return driver.findElement(EXPECTED_RESULT_TEXT).getText();
    }

    public String loginInAccount() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        return driver.findElement(EXPECTED_RESULT_TEXT).getText();
    }

    public String loginViaRegistration() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.findElement(REGISTER_BUTTON).click();
        driver.findElement(COME_IN).click();
        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        return driver.findElement(EXPECTED_RESULT_TEXT).getText();
    }

    public String loginViaPasswordRecovery() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.findElement(RECOVER_PASSWORD_BUTTON).click();
        driver.findElement(COME_IN).click();
        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        return driver.findElement(EXPECTED_RESULT_TEXT).getText();
    }
}
