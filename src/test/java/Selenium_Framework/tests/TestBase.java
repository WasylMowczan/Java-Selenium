package Selenium_Framework.tests;

import Selenium_Framework.configuration.ConfigurationProperties;
import Selenium_Framework.configuration.PropertiesLoader;
import Selenium_Framework.driver.BrowserType;
import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.driver.manager.DriverUtils;
import org.testng.annotations.*;

import java.util.Properties;

import static Selenium_Framework.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType){
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
