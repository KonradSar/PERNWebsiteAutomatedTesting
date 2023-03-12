package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.CustomWebElementActions.scrollToElement;

public class FuelServicesPage extends BasePage {
    private final HeaderSection headerSection;
    private final FooterSection footerSection;
    private final WebDriverWait webDriverWait;
    private final By mapOfLoactions = By.cssSelector("#location-map");
    private final WebElement elementOnTheMap = driver.findElement(By.cssSelector("#Baza_paliw_lodzkie_Baza_Paliw_nr_1_w_Koluszkach > circle"));
    private final By koluszkiLabel = By.cssSelector(".locations-map-list__single--active");
    private final WebElement map = driver.findElement(mapOfLoactions);

    public FuelServicesPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public BasesLocationDetailsPage selectKoluszkiBaseLocation() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(mapOfLoactions));
        scrollToElement(map, driver);
        Actions actions = new Actions(driver);
        actions.doubleClick(elementOnTheMap).build().perform();
        actions.click(elementOnTheMap).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(koluszkiLabel));
        var koluszkiLabelWebElement = driver.findElement(koluszkiLabel);
        actions.click(koluszkiLabelWebElement).build().perform();
        return new BasesLocationDetailsPage(driver);
    }
}
