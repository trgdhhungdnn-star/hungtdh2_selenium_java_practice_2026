package tests;

import base.BaseTest;
import listeners.TestListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import untils.JsonUtils;

import java.util.Arrays;
import java.util.List;

@Listeners(TestListener.class)
public class ProductTest extends BaseTest {
    User user = JsonUtils.getUser("validUser");
    @Test
    public void TC3_addProductTest() {
        User userLogin = JsonUtils.getUser("validUser");
        User userInformation = JsonUtils.getUser("userInformation");
        loginPage.loginAs(userLogin.getUsername(),userLogin.getPassword());
        productPage = new ProductPage(driver);
        productPage.clickAddLabsBackpack();
        String expectedProduct = productPage.getLabsBackpackName();
        productPage.clickToCart();

        CartPage cartPage = new CartPage(driver);
        String actualProduct = cartPage.getInventoryItemName();
        Assert.assertEquals(expectedProduct,actualProduct);
        cartPage.clickCheckoutBtn();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        String expectedCITitle = "Checkout: Your Information";
        String actualCITitle = checkoutInformationPage.CheckoutInformationTitle();
        Assert.assertEquals(actualCITitle,expectedCITitle);
        checkoutInformationPage.fillInformation(userInformation.getFirstname(),userInformation.getLastname(),userInformation.getZipcode());

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        String expectedCOTitle = "Checkout: Overview";
        String actualCOTitle = checkoutOverviewPage.CheckoutOverviewTitle();
        Assert.assertEquals(actualCOTitle,expectedCOTitle);
        checkoutOverviewPage.clickFinishBtn();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String expectedCompleteMess = "Thank you for your order!";
        String actualCompletedMess = checkoutCompletePage.CheckoutCompleteTitle();
        Assert.assertEquals(actualCompletedMess,expectedCompleteMess);

    }

    @Test
    public void TC4_AddMultiProductTest(){
        User userLogin = JsonUtils.getUser("validUser");
        User userInformation = JsonUtils.getUser("userInformation");
        loginPage.loginAs(userLogin.getUsername(),userLogin.getPassword());
        productPage = new ProductPage(driver);
        List<String> expectedProductNames = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket"
        );
        productPage.clickAddToCardMulti(expectedProductNames);
        productPage.clickToCart();
        CartPage cartPage = new CartPage(driver);
        List<String> actualProductNames = cartPage.getProductNamesInCart();
        Assert.assertEquals(actualProductNames.size(),expectedProductNames.size());
        Assert.assertEquals(actualProductNames,expectedProductNames);
        cartPage.clickCheckoutBtn();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        String expectedCITitle = "Checkout: Your Information";
        String actualCITitle = checkoutInformationPage.CheckoutInformationTitle();
        Assert.assertEquals(actualCITitle,expectedCITitle);
        checkoutInformationPage.fillInformation(userInformation.getFirstname(),userInformation.getLastname(),userInformation.getZipcode());

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        String expectedCOTitle = "Checkout: Overview";
        String actualCOTitle = checkoutOverviewPage.CheckoutOverviewTitle();
        Assert.assertEquals(actualCOTitle,expectedCOTitle);
        checkoutOverviewPage.clickFinishBtn();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String expectedCompleteMess = "Thank you for your order!";
        String actualCompletedMess = checkoutCompletePage.CheckoutCompleteTitle();
        Assert.assertEquals(actualCompletedMess,expectedCompleteMess);
    }
}
