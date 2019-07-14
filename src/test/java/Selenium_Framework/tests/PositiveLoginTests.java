package Selenium_Framework.tests;

import Selenium_Framework.driver.manager.DriverUtils;
import Selenium_Framework.page.objects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static Selenium_Framework.navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTests extends TestBase {

    @TmsLink("ID-02")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword(){
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerIsDisplayed();
    }
}
