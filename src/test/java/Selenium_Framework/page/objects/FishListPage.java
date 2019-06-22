package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    @FindBy (css = "tr:nth-child(2) a")
    private WebElement angelFishIdLink;

    private WebDriver driver;

    public FishListPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void clickOnAngilFish(){
        angelFishIdLink.click();
    }
}
