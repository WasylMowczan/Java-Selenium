package Selenium_Basic_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;


public class CheckBoxesTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @Test
    public void checkBoxesTest(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        assertFalse(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());

        checkbox1.click();
        checkbox2.click();

        assertTrue(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }


}
