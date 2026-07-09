package tests;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import untils.JsonUtils;

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
}
