package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    public WebDriver driver;

    @FindBy (css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckOutButton;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnProceedToCheckOut(){
        proceedToCheckOutButton.click();
    }
}
