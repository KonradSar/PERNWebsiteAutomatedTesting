package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {
    private final HeaderSection headerSection;
    private final FooterSection footerSection;
    private final WebDriverWait webDriverWait;
    private final By resulstCounter = By.cssSelector("div[class='col-lg-6 col-sm-12']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public boolean isAnyResultNumber() {
        var resultsCounter = driver.findElement(resulstCounter);
        return !resultsCounter.getText().equals("Liczba wyników: 0");
    }
}
