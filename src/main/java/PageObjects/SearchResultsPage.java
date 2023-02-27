package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;

    private final By resulstCounter = By.cssSelector("[class='row search_options']>div:not([class$='text-right'])");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public boolean isAnyResultNumber() {
        var resultsCounter = driver.findElement(resulstCounter);
        return !resultsCounter.getText().equals("Liczba wyników: 0");
    }
}
