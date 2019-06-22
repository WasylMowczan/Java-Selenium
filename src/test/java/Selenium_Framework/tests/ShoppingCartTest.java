package Selenium_Framework.tests;

import Selenium_Framework.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserShallNotProceedToCheckOut(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFishImageButton();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAngilFish();

        AngelFishListPage angelFishListPage = new AngelFishListPage();
        angelFishListPage.clickOnAddToCartSmallAngelFish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckOut();

        loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

}
