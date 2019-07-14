package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import Selenium_Framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Selenium_Framework.generic.assertions.AssertWebElement.assertThat;

public class FooterPage {

    private Logger logger = LogManager.getLogger(FooterPage.class);

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLohinLogo;

    public FooterPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        logger.info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLohinLogo);
        assertThat(bannerAfterLohinLogo).isDisplayed();
        return this;
    }

}
