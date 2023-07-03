package ru.practicum.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchFromPersonalAccountToConstructorPageObject {
    private WebDriver driver;

    private static final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    private static final By CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    private static final By LOGO = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    public SwitchFromPersonalAccountToConstructorPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get(REGISTRATION_URL);
    }

    public void switchingFromPersonalAccount(){
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    public void switchingFromPersonalAccountViaLogo(){
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
        driver.findElement(LOGO).click();
    }
}
