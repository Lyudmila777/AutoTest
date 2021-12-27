package com.zadanie;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// ОТКРЫТЬ СТРАНИЦУ chrome И ВВЕСТИ СЛОВО selenium
public class SeleniumTest {
    public static void main(String[] args) {
        //Инициализация драйвера через setProperty
        System.setProperty ("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver ();// Инициализация объекта, к которому будем обращаться к экземпляру драйвера
        driver.manage ().window ().maximize ();// управление драйвером
        driver.get ("https://google.com");// открытие странички
        WebElement el = driver.findElement (By.name ("q"));//на страничке находим элемент синтаксиса
        //вебэлемент хранит ссылку на элемент, обект ВУ хранит ссылку на локатор
        el.sendKeys ("selenium");// говорим селениуму, чтобы он в этот элемент напечатал слово selenium
        el.sendKeys (Keys.ENTER);//и далее чтобы нажал ентер
    }
}
