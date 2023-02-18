package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleMapsPage {
    public GoogleMapsPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    protected WebDriver driver;

    protected WebElement webElement;

    protected WebDriverWait webDriverWait;

    protected By searchInput = By.cssSelector("#gs_lc50 input[value='place/PERN S.A. Wyszogrodzka 133 płock']");

    public String getSearchInputValue() {
        return driver.findElement(searchInput).getAttribute("value");
    }
}
