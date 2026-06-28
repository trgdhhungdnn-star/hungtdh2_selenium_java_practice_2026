package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By homeTitle = By.xpath("//*[@data-test='title']");

    public boolean isProductPageDisplayed() {
        return isDisplayed(homeTitle);
    }
}
