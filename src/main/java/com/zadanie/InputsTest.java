package com.zadanie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest {
            WebDriver driver;

        @BeforeEach
        public void setUp() {
            System.setProperty ("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver ();// Инициализация объекта, к которому будем обращаться к экземпляру драйвера
            driver.get ("http://the-internet.herokuapp.com/inputs");
        }
    /*
    Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
     */

        @Test
        public void inputsTest() {

            driver.findElement (By.xpath ("//input")).sendKeys (Keys.ARROW_UP);
            String upKeyResult = driver.findElement (By.xpath ("//input")).getAttribute ("value");
            assertEquals (upKeyResult, "1");
            driver.findElement (By.xpath ("//input")).sendKeys (Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
            String downKeyResult = driver.findElement (By.xpath ("//input")).getAttribute ("value");
            assertEquals (downKeyResult, "-3");

            // проверить ручной ввод буквенных симолов
            driver.navigate ().refresh ();
            driver.findElement (By.xpath ("//input")).sendKeys ("www");
            String alphaResult = driver.findElement (By.xpath ("//input")).getAttribute ("value");
            assertEquals (alphaResult, "");

            // проверить ручной ввод цифровых симолов
            driver.navigate ().refresh ();
            driver.findElement (By.xpath ("//input")).sendKeys ("12");
            String numericResult = driver.findElement (By.xpath ("//input")).getAttribute ("value");
            assertEquals (numericResult, "12");
        }


    @AfterEach
    public void TearDown() {
        driver.quit ();
    }

}

