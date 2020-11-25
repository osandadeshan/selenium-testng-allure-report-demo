package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By usernameLabel = By.xpath("//div[@class='header_user_info']//span");
    private final By searchTextBox = By.id("search_query_top");
    private final By searchButton = By.cssSelector("button[name='submit_search']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUsername() {
        return getElement(usernameLabel).getText();
    }

    public void enterSearchItem(String itemName) {
        sendKeys(searchTextBox, itemName);
    }

    public void enterSearchButton() {
        click(searchButton);
    }

    public void searchItem(String itemName) {
        enterSearchItem(itemName);
        enterSearchButton();
    }
}
