package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String CheckoutOverviewTitle() {
        return driver.findElement(PageElement.CheckOutOverview.CheckOverviewTitle).getText();
    }

    public void clickFinishBtn() {
        click(PageElement.CheckOutOverview.FinishBtn);
    }
}
