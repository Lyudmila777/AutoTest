package com.zadanie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//ЗАДАНИЕ 3
//Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран,
// выбрать второй, проверить, что он выбран
//Локатор By.id(“dropdown”)
public class DropDownTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty ("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver ();// Инициализация объекта, к которому будем обращаться к экземпляру драйвера
        driver.get ("http://the-internet.herokuapp.com/ ");// открытие странички

    }

    @org.junit.jupiter.api.Test
    public void dropDownTest() {
        WebElement element1 = driver.findElement (By.xpath ("select[@id='dropdown']/option[@value='1']"));
        element1.click ();
        Assertions.assertEquals (element1.isSelected (), true, "Option 1 is selected");
        WebElement element2 = driver.findElement (By.xpath ("select[@id='dropdown']/option[@value='2']"));
        element2.click ();
        Assertions.assertEquals (element2.isSelected (), true, "Option 2 is selected");
    }

    @AfterEach
    public void TearDown() {
        driver.quit ();
    }

}


