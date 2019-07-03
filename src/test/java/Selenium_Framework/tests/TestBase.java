package Selenium_Framework.tests;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Selenium_Framework.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {


    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chromedriver.driver","C:/bin/chromedriver.exe");

        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
