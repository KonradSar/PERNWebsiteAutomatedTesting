package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    private By resulstCounter = By.cssSelector("[class='row search_options']>div:not([class$='text-right'])");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAnyResultNumber() {
        boolean isAnyResult = false;
        WebElement resultsCounter = driver.findElement(resulstCounter);
        if (!resultsCounter.getText().equals("Liczba wyników: 0")) {
            isAnyResult = true;
        }
        return isAnyResult;
    }
}
