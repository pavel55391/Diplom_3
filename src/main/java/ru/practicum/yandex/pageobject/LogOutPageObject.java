package ru.practicum.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogOutPageObject {
    private WebDriver driver;

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By LOGIN_BUTTON_MAIN_PAGE = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By EMAIL_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By LOG_OUT_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");


    public LogOutPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(REGISTRATION_URL);
    }

    public String logOut() {
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();
        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(LOG_OUT_BUTTON).click();
        return driver.findElement(LOGIN_BUTTON).getText();
    }
}
