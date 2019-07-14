package Selenium_Framework.tests;

import Selenium_Framework.driver.manager.DriverUtils;
import Selenium_Framework.page.objects.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Selenium_Framework.navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTest extends TestBase{

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of the test is to log in using not proper username and password" +
    "and check if warning message Invalid username or password is displayed")
    public void asUserTryToLoginWithIncorrectLoginAndPassword(){

        DriverUtils.navigateToPage(LOGIN_URL);


        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();
        loginPage
                .assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }
}
