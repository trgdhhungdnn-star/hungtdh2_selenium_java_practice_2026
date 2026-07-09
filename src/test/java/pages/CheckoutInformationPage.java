package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public String CheckoutInformationTitle() {
        return driver.findElement(PageElement.CheckOutInformation.CheckOutInformationTitle).getText();
    }

    public void fillInformation (String firstname, String lastname, String zipcode) {
        type(PageElement.CheckOutInformation.FirstName, firstname);
        type(PageElement.CheckOutInformation.LastName, lastname);
        type(PageElement.CheckOutInformation.ZipCode, zipcode);
        click(PageElement.CheckOutInformation.ContinueBtn);
    }

}
