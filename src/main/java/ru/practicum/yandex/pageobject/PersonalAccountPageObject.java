package ru.practicum.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPageObject {

    private WebDriver driver;

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By LOGIN_BUTTON_MAIN_PAGE = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By LOGIN = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    public PersonalAccountPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(REGISTRATION_URL);
    }

    public String transferToPersonalAccount() {
        driver.findElement(LOGIN_BUTTON_MAIN_PAGE).click();
        return driver.findElement(LOGIN).getText();
    }
}
