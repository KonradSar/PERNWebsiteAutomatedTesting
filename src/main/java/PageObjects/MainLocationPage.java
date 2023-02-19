package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainLocationPage extends BasePage {

    private By navigateBtn = By.cssSelector("a.nawigacja-obiekt");

    private WebDriverWait webDriverWait;

    public MainLocationPage(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public MainLocationPage clickOnNavigateBtn() {
        WebElement oilServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(navigateBtn));
        oilServicesTab.click();
        return new MainLocationPage(driver);
    }

}
