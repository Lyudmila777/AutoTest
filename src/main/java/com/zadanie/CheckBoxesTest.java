package com.zadanie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//ЗАДАНИЕ 2
//Checkboxes - проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
// Проверить, что второй чекбокс checked, сделать unheck, проверить, что он unchecked
//Локатор By.cssSelector(“[type=checkbox]”)
public class CheckBoxesTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver ();
        driver.get ("http://the-internet.herokuapp.com//checkboxes ");
    }

    @Test
    public void сheckBoxesTest() {
        By checkboxes = By.tagName ("input");
//        By checkboxes = By.cssSelector ("[type()='checkbox']");
      List<WebElement> checkBoxes = driver.findElements (By.tagName ("input"));
       assertEquals (checkBoxes.get(0).isSelected (), false, "the 1st checkbox is unchecked");
        checkBoxes.get(0).click ();
       assertEquals (checkBoxes.get(0).isSelected (), true, "the 1st checkbox is checked");
        assertEquals(checkBoxes.get(1).isSelected(), true, "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(), false, "the 2nd checkbox is unchecked");
    }

    @AfterEach
    public void TearDown() {
        driver.quit ();
    }

}


