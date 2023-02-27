package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuelServicesPage extends BasePage {
    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;
    private final By mapOfLoactions = By.cssSelector("#location-map");

    private final WebElement elementOnTheMap = driver.findElement(By.cssSelector("#baza_paliw #Baza_paliw_lodzkie_Baza_Paliw_nr_1_w_Koluszkach > circle"));

    private final WebElement koluszkiLabel = driver.findElement(By.xpath(".//a[@href='https://www.pern.pl/obiekty/baza-paliw-nr-1-w-koluszkach/' and not(contains(@class, 'locations-map-list__url'))]"));

    private final WebElement map = driver.findElement(mapOfLoactions);


    public FuelServicesPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public BasesLocationDetailsPage selectKoluszkiBaseLocation() {
        scrollToMapElement();
        Actions actions = new Actions(driver);
        actions.doubleClick(elementOnTheMap).build().perform();
        actions.click(elementOnTheMap).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(koluszkiLabel));
        actions.click(koluszkiLabel).build().perform();
        return new BasesLocationDetailsPage(driver);
    }

    private void scrollToMapElement() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(mapOfLoactions));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", map);
    }

}
