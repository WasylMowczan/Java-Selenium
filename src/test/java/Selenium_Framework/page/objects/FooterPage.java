package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLohinPage;

    private WebDriver driver;

    public FooterPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLohinPage);
        boolean isDisplayed = bannerAfterLohinPage.isDisplayed();
        return isDisplayed;
    }

}
