package com.zadanie;

import com.zadanie.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstTest {
    WebDriver driver;

    @Test
    public void successAuth() {
        driver = Driver.getDriver ();
        driver.get ("https://opensource-demo.orangehrmlive.com/");

        driver.findElement (By.id("txtUsername")).sendKeys ("Admin");
        driver.findElement (By.id("txtPassword")).sendKeys ("admin123");
        driver.findElement (By.id("btnLogin")).click ();
        String userName = driver.findElement(By.id("welcome")).getText();
        Assertions.assertEquals ("Welcome Paul", userName);

        driver.quit ();

    }
}


