package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    private WebDriver driver;

    public TopMenuPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSignInLink(){
        WaitForElement.waitUntilElementClickable(signOnLink);
        signOnLink.click();
    }

}
