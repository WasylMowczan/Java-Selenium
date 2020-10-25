package com.wasylmowczan.SeleniumFramework.page.objects;

import com.wasylmowczan.SeleniumFramework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
