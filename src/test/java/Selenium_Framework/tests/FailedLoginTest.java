package Selenium_Framework.tests;

import Selenium_Framework.driver.manager.DriverUtils;
import Selenium_Framework.page.objects.LandingPage;
import Selenium_Framework.page.objects.LoginPage;
import Selenium_Framework.page.objects.TopMenuPage;
import org.testng.annotations.Test;

import static Selenium_Framework.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends TestBase{


    @Test
    public void asUserTryToLoginWithIncorrectLoginAndPassqord(){

        DriverUtils.navigateToPage(LOGIN_URL);


        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");

    }
}
