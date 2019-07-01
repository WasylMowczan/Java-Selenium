package Selenium_Framework.tests;

import Selenium_Framework.page.objects.LandingPage;
import Selenium_Framework.page.objects.LoginPage;
import Selenium_Framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends TestBase{


    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassqord(){


        LandingPage landingPage = new LandingPage();
        landingPage.
                clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUsernameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");

    }
}
