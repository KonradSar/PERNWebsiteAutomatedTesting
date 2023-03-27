package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleMapsPage {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;
    public GoogleMapsPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getSearchInputValue() {
        return driver.getCurrentUrl();
    }
}
