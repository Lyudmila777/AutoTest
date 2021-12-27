package com.zadanie;

import com.zadanie.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPageTest {
    WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver ();
        driver.get ("https://yandex.ru ");
    }

    @Test
    public void successAuth() {
        driver.findElement (By.xpath ("//div[@class='desk-notif-card__login-new-item-title']")).click ();

//
//        driver.findElement (By.xpath ("//input[@class='Textinput-Control']")).sendKeys ("Ludawolchenko");
//        driver.findElement (By.xpath ("\"//img[@class='user-pic__image'][1]\"")).click ();
        // driver.findElement (By.xpath ("\"//img[@class='user-pic__image'][1]\"")).click ();


    }
}


