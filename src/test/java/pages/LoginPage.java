package pages;

import base.BasePage;
import elements.PageElement;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAs (String username, String password) {
        logger.info("Login with username", username);
        type(PageElement.Login.UserName, username);
        type(PageElement.Login.PassWord, password);
        click(PageElement.Login.LoginBtn);
        logger.info("Login Completed");
    }

    public String getErrorMessage() {
        return getText(PageElement.Login.ErrorMessage);
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(PageElement.Login.LoginBtn);
    }

}
