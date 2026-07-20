package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getInventoryItemName() {
        return driver.findElement(PageElement.YourCart.InventoryItem).getText();
    }

    public void clickCheckoutBtn() {
        driver.findElement(PageElement.YourCart.CheckoutBtn).click();
        logger.info("Click Checkout button");
    }

    public List<String> getProductNamesInCart() {
        List<WebElement> elements = driver.findElements(PageElement.YourCart.InventoryItemList);
        List<String> productNames = new ArrayList<>();
        for (WebElement element : elements) {
            productNames.add(element.getText());
        }
        return productNames;
    }
}
