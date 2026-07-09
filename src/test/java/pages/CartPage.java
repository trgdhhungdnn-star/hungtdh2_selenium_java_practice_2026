package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getInventoryItemName() {
        return driver.findElement(PageElement.YourCart.InventoryItem).getText();
    }

    public void clickCheckoutBtn() {
        driver.findElement(PageElement.YourCart.CheckoutBtn).click();
    }
}
