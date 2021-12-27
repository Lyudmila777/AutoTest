package com.zadanie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;


// ПОСЛЕ ПРОМЕЖУТОЧНОГО ТЕСТА, НАМ ОСТАЕТСЯ СОЗДАТЬ создать новый класс com.zadanie.AuthorizationTest.AuthPage, переменную authPage в нашем классе
//и объект authPage ;
//новый класс даст возможность использовать его при работе, например на главной странице
//driver.findElement (UserName).sendKeys ЗАМЕНИТЬ НА МЕТОД authPage.insertLogin
public class Authorization1Test {
    WebDriver driver;
    AuthPage authPage;
    MainPage mainPage;

    // выносим ЛОКАТОРЫ, ТЕМ САМЫМ:
//  1. Локаторы будут в одном месте
//  2. это ПОЗВОЛИТ ИХ МЕНЯТЬ ПО НАЗВАНИЮ
// 3.  И ПО СПОСОБУ ПОИСКА, НАПРИМЕР, id поменяется, можно искать по XPATH
    @BeforeEach
    public void setUp() {
        //Инициализация driver
        driver = Driver.getDriver ();
        authPage  = new AuthPage (driver);
        mainPage = new MainPage (driver);
        driver.get ("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void successAuth() {
        authPage.insertLogin ("Admin");
        authPage.insertPassword ("admin123");
        authPage.clickSignInButton ();
        String userName = mainPage.getUserName ();
        Assertions.assertEquals ("Welcome Shiv", userName);

    }

    @Test
    public void wrongPassword() {
        authPage.insertLogin ("Admin");
        authPage.insertPassword ("admin123456");
        authPage.clickSignInButton ();

        String warningText = authPage.getErrorMessage ();
        Assertions.assertEquals ("Invalid credentials", warningText);
    }

    @Test()
    public void emptyPassword() {
        authPage.insertLogin ("Admin");
        authPage.clickSignInButton ();

        String warningText = authPage.getErrorMessage ();
        Assertions.assertEquals ("Password cannot be empty", warningText);

    }

    @AfterEach
    public void TearDown() {

        driver.quit ();
    }

}
