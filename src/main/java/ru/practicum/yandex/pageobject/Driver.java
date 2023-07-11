package ru.practicum.yandex.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private WebDriver driver;

    public Driver() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Users\\pawel_kwyp1aj\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
