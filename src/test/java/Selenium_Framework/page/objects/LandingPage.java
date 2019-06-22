package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;


    private WebDriver driver;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void clickOnEnterStoreLink(){
        WaitForElement.waitUntilElementClickable(enterStoreLink);
        enterStoreLink.click();
    }
}
