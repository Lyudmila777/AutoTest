package com.zadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static final By USER_NAME_LOCATOR = By.id ("welcome");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return driver.findElement (USER_NAME_LOCATOR).getText ();
    }
}

