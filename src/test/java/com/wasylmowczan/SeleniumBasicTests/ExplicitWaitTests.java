package com.wasylmowczan.SeleniumBasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement(){
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeButton = driver.findElement(By.id("btn"));
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement messageAlert = driver.findElement(By.id("message"));
        assertEquals(messageAlert.getText(), "It's gone!");

        WebElement addButton = driver.findElement(By.id("btn"));
        addButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementVisible(checkbox);
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
