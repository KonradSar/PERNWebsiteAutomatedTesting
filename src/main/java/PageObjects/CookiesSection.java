package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesSection {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;
    protected By rejectCookiesBtn = By.xpath(".//div[@class='VtwTSb']/form[1]");
    protected By closeCookiesBtn = By.cssSelector(".contextual-sign-in-modal__modal-dismiss");

    public CookiesSection(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public CookiesSection closeYouTubeCookiesBtn() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rejectCookiesBtn));
        driver.findElement(rejectCookiesBtn).click();
        return new CookiesSection(driver);
    }

    public CookiesSection closeLinkedInCookiesBtn() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(closeCookiesBtn));
        driver.findElement(closeCookiesBtn).click();
        return new CookiesSection(driver);
    }
}

