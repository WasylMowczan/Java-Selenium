package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LandingPage extends BasePage{

    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    @Step("Click on Enter Store link")
    public TopMenuPage clickOnEnterStoreLink(){
        WaitForElement.waitUntilElementClickable(enterStoreLink);
        enterStoreLink.click();
        log().info("Clicked on Enter Store Link");
        return new TopMenuPage();
    }
}
