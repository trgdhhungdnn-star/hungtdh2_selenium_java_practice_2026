package tests;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import untils.JsonUtils;

public class LoginTest extends BaseTest {
    @Test
    public void TC01_loginsuccess() {
        User user = JsonUtils.getUser("validUser");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.loginAs(user.getUsername(),user.getPassword());

        Assert.assertTrue(productPage.isProductPageDisplayed(),
                "User should be redirected to Product page after login");
    }
    @Test
    public void TC02_loginfail() {
        User user = JsonUtils.getUser("invalidUser");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs(user.getUsername(),user.getPassword());

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Incorrect error message is displayed");
    }
}
