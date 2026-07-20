package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPageDisplayed() {
        return isDisplayed(PageElement.Product.homeTitle);
    }

    public String getLabsBackpackName() {
        return driver.findElement(PageElement.Product.LabsBackpackName).getText();
    }

    public void clickAddLabsBackpack() {
        driver.findElement(PageElement.Product.LabsBackpackAdd).click();
        logger.info("Add Labs Backpack to Cart");
    }

    public void clickToCart() {
        driver.findElement(PageElement.Product.ShoppingCartLink).click();
    }

    public void clickAddToCardMulti(List<String> productNames) {
        for (String productName : productNames) {
            click(PageElement.Product.addToCartBtn(productName));
        }
    }

}
