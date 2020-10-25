package com.wasylmowczan.SeleniumFramework.tests;

import com.wasylmowczan.SeleniumFramework.configuration.ConfigurationProperties;
import com.wasylmowczan.SeleniumFramework.configuration.PropertiesLoader;
import com.wasylmowczan.SeleniumFramework.driver.BrowserType;
import com.wasylmowczan.SeleniumFramework.driver.manager.DriverManager;
import com.wasylmowczan.SeleniumFramework.driver.manager.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.util.Properties;

import static com.wasylmowczan.SeleniumFramework.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Settinh up browser to: {browserType} and navigation to Home page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType){
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
