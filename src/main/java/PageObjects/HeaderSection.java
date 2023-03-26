package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection extends BasePage {
    private final WebDriverWait webDriverWait;
    private final By activeSearchInput = By.cssSelector("input.search-modal__input");

    public HeaderSection(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void openTabElement(HeaderTab headerTab) {
        driver.findElement(headerTab.tabLocator).click();
    }

    public MainPage searchInSomeText(String phrase) {
        var searchInput = webDriverWait.until(ExpectedConditions.elementToBeClickable(activeSearchInput));
        searchInput.sendKeys(phrase);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).build().perform();
        return new MainPage(driver);
    }
}
