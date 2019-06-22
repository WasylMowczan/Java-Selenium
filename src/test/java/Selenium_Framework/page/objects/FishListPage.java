package Selenium_Framework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    @FindBy (css = "tr:nth-child(2) a")
    private WebElement angelFishIdLink;

    private WebDriver driver;

    public FishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAngilFish(){
        angelFishIdLink.click();
    }
}
