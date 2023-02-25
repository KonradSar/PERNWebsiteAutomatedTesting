package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasesLocationDetailsPage extends BasePage {
    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;

    private final By koluszkiBaseBanner = By.cssSelector(".tytul-obiekt");

    public BasesLocationDetailsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public boolean isKoluszkiDetailDisplayed() {
        var koluszkiBannerWebElement = driver.findElement(koluszkiBaseBanner);
        webDriverWait.until(ExpectedConditions.visibilityOf(koluszkiBannerWebElement));
        return koluszkiBannerWebElement.getText().equals("Baza Paliw nr 1 w Koluszkach");
    }
}
