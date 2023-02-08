package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubePage {
    protected WebDriver driver;

    protected WebElement webElement;

    public YoutubePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    protected WebDriverWait webDriverWait;

    By rejectCookiesBtn = By.xpath(".//div[@class='VtwTSb']/form[1]");

    By inputSearch = By.xpath(".//input[@id='search']");

    public YoutubePage closeCookiesBtn() {
        driver.findElement(rejectCookiesBtn).click();
        return new YoutubePage(driver);
    }

    public YoutubePage searchOnYT(String value) {
        driver.findElement(inputSearch).sendKeys(value);
        driver.findElement(inputSearch).click();

        return new YoutubePage(driver);
    }
}
