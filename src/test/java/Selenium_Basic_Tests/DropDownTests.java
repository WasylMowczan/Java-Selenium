package Selenium_Basic_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DropDownTests {

    private ChromeDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
    public void checkBoxesTest(){

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select optionDropDown = new Select(dropdown);
        assertEquals(optionDropDown.getFirstSelectedOption().getText(),"Please select an option");

        optionDropDown.selectByVisibleText("Option 1");
        assertEquals(optionDropDown.getFirstSelectedOption().getText(),"Option 1");

        optionDropDown.selectByVisibleText("Option 2");
        assertEquals(optionDropDown.getFirstSelectedOption().getText(),"Option 2");
    }

    public void sleep(){
        try {
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
