package Selenium_Framework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLohinPage;

    private WebDriver driver;

    public FooterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isBannerAfterLoginDisplayed(){
        boolean isDisplayed = bannerAfterLohinPage.isDisplayed();
        return isDisplayed;
    }

}
