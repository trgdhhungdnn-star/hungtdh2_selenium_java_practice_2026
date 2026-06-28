package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By UserName = By.id("user-name");
    private static final By PassWord = By.id("password");
    private static final By LoginBtn = By.id("login-button");
    private static final By ErrorMessage = By.xpath("//*[@data-test='error']");

    public void loginAs (String username, String password) {
        type(UserName, username);
        type(PassWord, password);
        click(LoginBtn);
    }

    public String getErrorMessage() {
        return getText(ErrorMessage);
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(LoginBtn);
    }

}
