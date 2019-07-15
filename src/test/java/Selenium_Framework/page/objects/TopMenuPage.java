package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage extends BasePage{

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink(){
        WaitForElement.waitUntilElementClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on Link");
        return new LoginPage();
    }

}
