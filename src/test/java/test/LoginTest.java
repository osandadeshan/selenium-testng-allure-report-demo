package test;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.testng.Assert.assertEquals;
import static util.driver.DriverHolder.getDriver;

@Epic("User Management")
@Feature("Login")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void loginBeforeMethod() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testValidLogin() {
        loginPage.login("osanda@mailinator.com","1qaz2wsx@");
        assertEquals(new HomePage(getDriver()).getLoggedInUsername(), "Osanda Nimalarathna");
    }

    @Test(description = "Verify that an invalid user cannot login to the application")
    @Severity(CRITICAL)
    @Description("Verify that an invalid user cannot login to the application")
    @Story("As a user I should be able to login to the application")
    public void testInvalidLogin() {
        loginPage.login("osanda@mailinator.com","abc12");
        assertEquals(getDriver().getTitle(), "Login - My Store");
    }
}
