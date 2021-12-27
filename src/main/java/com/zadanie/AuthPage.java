package com.zadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class AuthPage {
    private static final By USERNAME_LOCATOR = By.id("txtUsername");
    private static final By PASSWORD_LOCATOR = By.id("txtPassword");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("btnLogin");
    private static final By ERROR_MESSAGE = By.id("spanMessage");

    private final WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertLogin(String login) {

        driver.findElement(USERNAME_LOCATOR).sendKeys(login);
    }

    public void insertPassword(String password) {

        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
    }

    public void clickSignInButton() {

        driver.findElement(SIGN_IN_BUTTON_LOCATOR).click();
    }

    public String getErrorMessage() {

        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public MainPage fullAuth(String login, String password) {
        insertLogin(login);
        insertPassword(password);
        clickSignInButton();

        return  new MainPage (driver);
    }
}


