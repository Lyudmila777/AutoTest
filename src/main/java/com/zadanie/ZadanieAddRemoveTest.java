package com.zadanie;

import com.zadanie.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//ЗАДАНИЕ 1
//добавить 2 элемента, удалить элемент, проверить количество элементов
public class ZadanieAddRemoveTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver ();
        driver.get ("http://the-internet.herokuapp.com/add_remove_elements/ ");

    }

    @org.junit.jupiter.api.Test
    public void addRemoveElementsTest() {
        driver.findElement ((By.xpath("//button[text()='Add Element']"))).click ();
        driver.findElement ((By.xpath("//button[text()='Add Element']"))).click ();
        driver.findElement (By.className("added-manually")).click ();
        int deletedButtonsQuantity = driver.findElements(By.className ("added-manually")).size ();
       Assertions.assertEquals (deletedButtonsQuantity, 1, "One button is remaining");
    }

    @AfterEach
    public void TearDown() {
        driver.quit ();
    }

}
