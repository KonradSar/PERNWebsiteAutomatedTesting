package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    protected WebDriver driver;

    protected WebElement webElement;

    protected WebDriverWait webDriverWait;

    protected By searchInput = By.xpath(".//input[@class='gLFyf']");
    //linijka 27 usunąć div

    protected By closeCookiesBtn = By.cssSelector("button#W0wltc>div");

    protected By cookiesPopup = By.cssSelector("div#CXQnmb");

    protected By searchBtn = By.cssSelector("input.gNO89b");

    public void sendValueToInputSearch(String value) throws InterruptedException {
        driver.navigate().to("https://www.google.pl/");
        closeCookiesView();
        driver.findElement(searchInput).sendKeys(value);
        Thread.sleep(4000);
    }

    public GoogleSearchPage closeCookiesView(){
        WebElement cookiesBtn = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(closeCookiesBtn));
        cookiesBtn.click();
        return new GoogleSearchPage(driver);
    }


}
