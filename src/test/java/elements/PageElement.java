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
}
