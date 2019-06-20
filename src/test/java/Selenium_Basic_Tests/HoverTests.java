package Selenium_Basic_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest(){
        WebElement photo1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(photo1).perform();
        sleep();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement firstPhotoCapture = driver.findElement(By.xpath("//div[1]/div/h5"));
        assertEquals(firstPhotoCapture.getText(), "name: user1");
        sleep();
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
