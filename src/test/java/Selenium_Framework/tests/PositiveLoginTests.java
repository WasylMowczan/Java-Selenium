package Selenium_Framework.tests;

import Selenium_Framework.page.objects.FooterPage;
import Selenium_Framework.page.objects.LandingPage;
import Selenium_Framework.page.objects.LoginPage;
import Selenium_Framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {


    @Test
    public void asUserLoginUsingValidLoginAndPassword(){
        LandingPage landingPage = new LandingPage();
        boolean isBannerAfterLoginDisplayed = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUsernameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }

}
