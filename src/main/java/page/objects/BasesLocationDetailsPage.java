package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasesLocationDetailsPage extends BasePage {
    private final HeaderSection headerSection;
    private final FooterSection footerSection;
    private final WebDriverWait webDriverWait;
    private final By koluszkiBaseBanner = By.cssSelector(".tytul-obiekt");

    public BasesLocationDetailsPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public boolean isKoluszkiDetailDisplayed() {
        var koluszkiBannerWebElement = driver.findElement(koluszkiBaseBanner);
        webDriverWait.until(ExpectedConditions.visibilityOf(koluszkiBannerWebElement));
        return koluszkiBannerWebElement.getText().equals("Baza Paliw nr 1 w Koluszkach");
    }
}
