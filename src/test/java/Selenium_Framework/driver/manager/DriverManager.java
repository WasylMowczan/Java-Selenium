package Selenium_Framework.driver.manager;

import Selenium_Framework.configuration.LocalWebDriverProperties;
import Selenium_Framework.driver.BrowserFactory;
import Selenium_Framework.driver.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver = null;
    }
}
