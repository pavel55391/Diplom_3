package ru.practicum.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SuccessfulTegistrationPageObject {
    private WebDriver driver;

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By EXPECTED_RESULT_TEXT = By.xpath("//*[@id=\"root\"]/div/main/div/nav/p");
    private static final By EMAIL_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private static final By EXPECTED_INCORRECT_RESULT_TEXT = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    private static final String FIELD_TO_FILL = "//*[@id=\"root\"]/div/main/div/form/fieldset[%d]/div/div/input";

    public SuccessfulTegistrationPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(REGISTRATION_URL);
    }

    public String checkSuccessfulRegistration() {
        UserData firstUser = new UserData("Никита", "pavez_17@gmail.com", "123456qqq");
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 1))).sendKeys(firstUser.getName());
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 2))).sendKeys(firstUser.getEmail());
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 3))).sendKeys(firstUser.getPassword());

        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();

        driver.findElement(EMAIL_FIELD).sendKeys("pavelz_16@gmail.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("123qaz123");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(EXPECTED_RESULT_TEXT).getText();
    }

    public String errorForIncorrectPassword() {
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 1))).sendKeys("Никитафй");
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 2))).sendKeys("pavez_178i6w66@gmail.com");
        driver.findElement(By.xpath(String.format(FIELD_TO_FILL, 3))).sendKeys("123");
        driver.findElement(LOGIN_BUTTON).click();
        return driver.findElement(EXPECTED_INCORRECT_RESULT_TEXT).getText();
    }
}
