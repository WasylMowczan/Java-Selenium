package Selenium_Basic_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WebElementsTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.diver", "C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");
        String typeUserNameField = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameField, "Selenium Start");
    }

    @Test
    public void filePickingTest(){
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\Users\\Julia\\Pictures\\1.jpg");
        sleep();
    }

    @Test
    public void typingAndCleaningVelue(){
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");
        String typeUserNameField = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameField, "Selenium Start");

        userNameField.clear();
        sleep();
        String emptyUserNameField = userNameField.getAttribute("value");
        assertEquals(emptyUserNameField, "");
    }

    @Test
    public void checkRadioButton(){
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));
        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void checkboxButtonTest(){
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.isSelected();

        sleep();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());
    }


    @Test
    public void dropDownListingTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option: options ) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOption = new ArrayList<String>();
        expectedNamesOfOption.add("Germany");
        expectedNamesOfOption.add("Poland");
        expectedNamesOfOption.add("UK");

        assertEquals(namesOfOptions, expectedNamesOfOption);

    }

    @Test
    public void selectingOptionsFromDropDown(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        sleep();

        countryDropDown.selectByIndex(1);
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

        countryDropDown.selectByValue("de_DE");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

        countryDropDown.selectByVisibleText("UK");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");

        sleep();
    }

    @Test
    public void checkIfElementsOnPageTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
    }

    @Test
    public void mouseMoveTest(){
        WebElement smileIcon = driver.findElement(By.id("smiley"));
        WebElement smileIcon2 = driver.findElement(By.id("smiley2"));

        Actions actions = new Actions(driver);

        actions.moveToElement(smileIcon).moveToElement(smileIcon2).build().perform();
    }



    public void sleep(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
