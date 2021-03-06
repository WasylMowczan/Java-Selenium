package com.wasylmowczan.SeleniumFramework.tests;

import com.wasylmowczan.SeleniumFramework.page.objects.*;
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
        loginPage.assertThatWarningIsDisplayed("You must sign on before attempting to check out. Please sign on and try checking out again.");

    }

}
