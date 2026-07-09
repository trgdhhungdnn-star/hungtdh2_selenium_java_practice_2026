package elements;

import org.openqa.selenium.By;

public class PageElement {
    private PageElement() {
    }
    public static final class Login {
        public static final By UserName = By.id("user-name");
        public static final By PassWord = By.id("password");
        public static final By LoginBtn = By.id("login-button");
        public static final By ErrorMessage = By.xpath("//*[@data-test='error']");
    }

    public static final class Product {
        public static final By homeTitle = By.xpath("//*[@data-test='title']");
        public static final By LabsBackpackName = By.xpath("//div[text()='Sauce Labs Backpack']");
        public static final By LabsBackpackAdd = By.id("add-to-cart-sauce-labs-backpack");
        public static final By ShoppingCartLink = By.xpath("//*[@data-test='shopping-cart-link']");
    }

    public static final class YourCart {
        public static final By InventoryItem = By.xpath("//*[@data-test='inventory-item-name']");
        public static final By CheckoutBtn = By.xpath("//*[@data-test='checkout']");
    }

    public static final class CheckOutInformation {
        public static final By CheckOutInformationTitle = By.xpath("//*[@data-test='title']");
        public static final By FirstName = By.xpath("//*[@data-test='firstName']");
        public static final By LastName = By.xpath("//*[@data-test='lastName']");
        public static final By ZipCode = By.xpath("//*[@data-test='postalCode']");
        public static final By ContinueBtn = By.xpath("//*[@data-test='continue']");
        public static final By CanCelBtn = By.xpath("//*[@data-test='cancel']");
    }

    public static final class CheckOutOverview {
        public static final By CheckOverviewTitle = By.xpath("//*[@data-test='title']");
        public static final By CanCelBtn = By.xpath("//*[@data-test='cancel']");
        public static final By FinishBtn = By.xpath("//*[@data-test='finish']");
    }

    public static final class CheckoutCompleted {
        public static final By SuccessMessage = By.xpath("//*[@data-test='complete-header']");
    }
}
