package Selenium_Framework.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getWebDriver(){
        if (driver == null)
        {
            System.setProperty("webdriver.chromedriver.driver","C:/bin/chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
