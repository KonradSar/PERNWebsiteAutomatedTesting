package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivacyPolicySection {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;
    protected By rejectPolicyPrivacyBtn = By.cssSelector("button[action-type='DENY']");

    public PrivacyPolicySection(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public PrivacyPolicySection closeLinkedINPrivacyPolicyView() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rejectPolicyPrivacyBtn));
        driver.findElement(rejectPolicyPrivacyBtn).click();
        return new PrivacyPolicySection(driver);
    }
}
