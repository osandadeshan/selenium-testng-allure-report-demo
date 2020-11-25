package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{

    private final By searchResultsList = By.xpath("//div[@class='left-block']//div[@class='product-image-container']");
    private final By firstSearchResultName = By.xpath("//div[@class='right-block']//h5//a");
    private final By firstSearchResultPrice = By.xpath("//div[@class='right-block']//span[@itemprop='price']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultCount() {
        return getElements(searchResultsList).size();
    }

    public String getFirstSearchResultName() {
        return getElement(firstSearchResultName).getText();
    }

    public String getFirstSearchResultPrice() {
        return getElement(firstSearchResultPrice).getText();
    }
}
