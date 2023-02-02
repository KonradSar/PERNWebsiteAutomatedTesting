package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuelsAndBiocomponentsRequirementsPage extends BasePage{
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    private By dieselFuelsRequirementsBtn = By.xpath(".//div[@class='col-8 builder-container__content']/div[@id='faq-simple']/div[2]//a");
    private By flashPointTableValue = By.xpath(".//div[@class='col-8 builder-container__content']/div[@id='faq-simple']/div[2]/div[@id='collapse2']//table//tr[8]");


    public FuelsAndBiocomponentsRequirementsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public FuelsAndBiocomponentsRequirementsPage clickOnDieseBtn(){
        WebElement requirementsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dieselFuelsRequirementsBtn));
        requirementsTab.click();
        return new FuelsAndBiocomponentsRequirementsPage(driver);
    }
    public void scrollToFlashPointTableValue() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(flashPointTableValue));
        WebElement flashPointValue = driver.findElement(flashPointTableValue);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flashPointValue);
        Actions actions = new Actions(driver);
        actions.moveToElement(flashPointValue).doubleClick(flashPointValue).build().perform();
        Thread.sleep(3000);
    }
}
