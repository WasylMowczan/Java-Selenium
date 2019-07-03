package Selenium_Framework.tests;

import Selenium_Framework.driver.manager.DriverUtils;
import Selenium_Framework.page.objects.FooterPage;
import Selenium_Framework.page.objects.LandingPage;
import Selenium_Framework.page.objects.LoginPage;
import Selenium_Framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static Selenium_Framework.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {


    @Test
    public void asUserLoginUsingValidLoginAndPassword(){
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        boolean isBannerAfterLoginDisplayed = loginPage
                .typeIntoUsernameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }

}
