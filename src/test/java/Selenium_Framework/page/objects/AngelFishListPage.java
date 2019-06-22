package Selenium_Framework.page.objects;

import Selenium_Framework.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {

    public WebDriver driver;

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelFishAddToCartButton;

    public AngelFishListPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAddToCartSmallAngelFish(){

        smallAngelFishAddToCartButton.click();
    }
}
