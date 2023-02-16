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
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;
    private By mapOfLoactions = By.cssSelector("#location-map");


    public FuelServicesPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public BasesLocationDetailsPage selectKoluszkiBaseLocation() {
        scrollToMapElement();
        Actions actions = new Actions(driver);
        WebElement elementOnTheMap = driver.findElement(By.cssSelector("#baza_paliw #Baza_paliw_lodzkie_Baza_Paliw_nr_1_w_Koluszkach"));
        actions.click(elementOnTheMap).build().perform();
        WebElement koluszkiLabel = driver.findElement(By.cssSelector("[href='https://www.pern.pl/obiekty/baza-paliw-nr-1-w-koluszkach/']"));
        actions.click(koluszkiLabel).build().perform();
        return new BasesLocationDetailsPage(driver);
    }

    private void scrollToMapElement() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(mapOfLoactions));
        WebElement map = driver.findElement(mapOfLoactions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", map);
    }

}
