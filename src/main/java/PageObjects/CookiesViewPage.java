package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookiesViewPage {
    protected WebDriver driver;

    public CookiesViewPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    protected WebDriverWait webDriverWait;

    By rejectCookiesBtn = By.xpath(".//div[@class='VtwTSb']/form[1]");

    public CookiesViewPage closeCookiesBtn() {
        driver.findElement(rejectCookiesBtn).click();
        return new CookiesViewPage(driver);
    }
}

