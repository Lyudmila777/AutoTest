package driver;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverChrome
{
    private static WebDriver driver;

    private DriverChrome() {
    }
    //try {
//        switch (System.getProperty("browser")) {
//            case "firefox": {
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty ("driver", "chrome");
            String drvr = System.getProperty ("driver");
            switch (drvr) {
                case "opera":
                    initFF ();
                    break;
                case "chrome":
                default:
                    initChrome ();
            }
        }
        return driver;
    }
    private static void initFF () {
    }
    private static void initChrome () {
        System.setProperty ("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("start-maxinized");
        driver = new ChromeDriver (options);
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));
    }

    @AfterEach
        public static void tearDown() {
        driver.quit ();
        driver = null;
    }
}
