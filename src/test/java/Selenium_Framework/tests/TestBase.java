package Selenium_Framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chromedriver.driver","C:/bin/chromedriver.exe");

        driver = DriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
