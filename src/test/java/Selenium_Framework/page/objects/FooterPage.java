package Selenium_Framework.page.objects;

import Selenium_Framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Selenium_Framework.generic.assertions.AssertWebElement.assertThat;

public class FooterPage extends BasePage{

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLohinLogo;

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLohinLogo);
        assertThat(bannerAfterLohinLogo).isDisplayed();
        return this;
    }

}
