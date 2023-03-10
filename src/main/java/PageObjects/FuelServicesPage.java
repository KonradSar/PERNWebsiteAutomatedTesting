package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuelServicesPage extends BasePage{
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
    public BasesLocationDetailsPage clickOnSelectedBase(int x, int y, String xpathValue){
        scrollToMapElement();
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().build().perform();
        WebElement elementOnTheMap = driver.findElement(By.xpath(xpathValue));
        actions.click(elementOnTheMap).build().perform();
        return new BasesLocationDetailsPage(driver);
    }

    private void scrollToMapElement() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(mapOfLoactions));
        WebElement map = driver.findElement(mapOfLoactions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", map);
    }

}
