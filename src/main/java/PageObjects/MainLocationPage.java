package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainLocationPage extends BasePage {
    private final By navigateBtn = By.cssSelector("a.nawigacja-obiekt");
    private final WebDriverWait webDriverWait;

    public MainLocationPage(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public MainLocationPage clickOnNavigateBtn() {
        var oilServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(navigateBtn));
        oilServicesTab.click();
        return new MainLocationPage(driver);
    }
}
