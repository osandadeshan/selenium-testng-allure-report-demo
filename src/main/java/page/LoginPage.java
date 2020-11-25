package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailTextBox = By.id("email");
    private final By passwordTextBox = By.id("passwd");
    private final By signInButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        sendKeys(emailTextBox, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextBox, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
    }
}
