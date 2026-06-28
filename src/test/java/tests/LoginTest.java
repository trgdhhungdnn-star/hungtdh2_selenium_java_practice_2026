package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {
    @Test
    public void TC01_loginsuccess() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.loginAs("standard_user","secret_sauce");

        Assert.assertTrue(productPage.isProductPageDisplayed(),
                "User should be redirected to Home page after login");
    }
    @Test
    public void TC02_loginfail() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("hungtruong","1234");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Incorrect error message is displayed");
    }
}
