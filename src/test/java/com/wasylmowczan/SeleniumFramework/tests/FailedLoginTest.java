package com.wasylmowczan.SeleniumFramework.tests;

import com.wasylmowczan.SeleniumFramework.driver.manager.DriverUtils;
import com.wasylmowczan.SeleniumFramework.page.objects.LoginPage;
import com.wasylmowczan.SeleniumFramework.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.wasylmowczan.SeleniumFramework.navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTest extends TestBase{

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
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
