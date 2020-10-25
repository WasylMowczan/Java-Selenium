package com.wasylmowczan.SeleniumFramework.page.objects;

import com.wasylmowczan.SeleniumFramework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
