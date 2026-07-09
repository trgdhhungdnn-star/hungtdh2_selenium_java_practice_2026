package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String CheckoutCompleteTitle() {
        return driver.findElement(PageElement.CheckoutCompleted.SuccessMessage).getText();
    }
}
