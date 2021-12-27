package com.zadanie;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// ПОЛУЧИЛСЯ ПРОМЕЖУТОЧНЫЙ ТЕСТ, НАМ ОСТАЕТСЯ СОЗДАТЬ создать новый класс com.zadanie.AuthorizationTest.AuthPage, переменную authPage в нашем классе
//и объект authPage ;
//новый класс даст возможность использовать его при работе, например на главной странице
//driver.findElement (UserName).sendKeys ЗАМЕНИТЬ НА МЕТОД authPage.insertLogin
public class AuthorizationTest {
    WebDriver driver;
    // выносим ЛОКАТОРЫ, ТЕМ САМЫМ:
//  1. Локаторы будут в одном месте
//  2. это ПОЗВОЛИТ ИХ МЕНЯТЬ ПО НАЗВАНИЮ
    // 3.  И ПО СПОСОБУ ПОИСКА, НАПРИМЕР, id поменяется, можно искать по XPATH
    By UserName = By.id ("txtUsername");//объект ВУ  инкапсулирует поиск на странице
    By Password = By.id ("txtPassword");//он знает, как искать элементы
    By signInButton = By.id ("btnLogin");

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver ();
        driver.get ("https://opensource-demo.orangehrmlive.com/");// открытие странички
    }

    @Test
    public void successAuth() {
        driver.findElement (UserName).sendKeys ("Admin");//находим локатор поля логина и вводи его
        // findElement - здесь нам ВУ возвращает web-элемент,
        // а у web-элемента есть метод sendKeys, при этом
        // web-элемент умеет работать с элементами на странице, а именно
        // у нас существует класс ВУ для поиска, который умеет искать по id,name. xpath
        driver.findElement (Password).sendKeys ("admin123");//находим локатор поля ПАРОЛЬ и
        //вводим валидный пароль
        driver.findElement (signInButton).click ();//нашли и нажали кнопку входа

        String userName = driver.findElement (By.id ("welcome")).getText ();

        Assertions.assertEquals ("Welcome Shiv", userName);//Проверяем, что мы вошли в кабинет
        // (находим имя пользователя) используя Assertions
    }

    @Test
    public void wrongPassword() {

        driver.findElement (UserName).sendKeys ("Admin");//находим локатор поля логина и вводим
        //логин валидный
        driver.findElement (Password).sendKeys ("Admin123456");//находим локатор поля ПАРОЛЬ и
        //вводим невалидный пароль
        driver.findElement (signInButton).click ();//нашли и нажали кнопку входа
        String warningText = driver.findElement (By.id ("spanMessage")).getText ();//
        Assertions.assertEquals ("Invalid credentials", warningText);//Проверили сообщение об ошибке авторизации,
        // используя Assertions
    }

    @AfterEach
    public void TearDown() {
        driver.quit ();
    }
}
