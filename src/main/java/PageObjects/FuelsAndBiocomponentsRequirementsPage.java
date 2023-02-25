package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FuelsAndBiocomponentsRequirementsPage extends BasePage {
    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;
    private final By dieselFuelsRequirementsBtn = By.xpath(".//div[@class='col-8 builder-container__content']/div[@id='faq-simple']/div[2]//a");
    private final By flashPointTableValue = By.cssSelector("#collapse2 .panel-body table tr:nth-of-type(8)");
    private final By temperatueValueRow = By.cssSelector("#collapse2 .panel-body table tr:nth-of-type(8)>td:nth-child(2)");


    public FuelsAndBiocomponentsRequirementsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public FuelsAndBiocomponentsRequirementsPage clickOnDieseBtn() {
        var requirementsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dieselFuelsRequirementsBtn));
        requirementsTab.click();
        return new FuelsAndBiocomponentsRequirementsPage(driver);
    }

    public void scrollToFlashPointTableValue() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(flashPointTableValue));
        var flashPointValue = driver.findElement(flashPointTableValue);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flashPointValue);
        Actions actions = new Actions(driver);
        actions.moveToElement(flashPointValue).doubleClick(flashPointValue).build().perform();
    }

    public boolean isFlashPointCorrect() {
        var flashPoint = driver.findElement(temperatueValueRow);
        return flashPoint.getText().contains("55,0");
    }
}
