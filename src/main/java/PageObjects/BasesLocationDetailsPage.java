package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasesLocationDetailsPage extends BasePage {
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    private By koluszkiBaseBanner = By.cssSelector(".tytul-obiekt");

    public BasesLocationDetailsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public boolean isKoluszkiDetailDisplayed() {
        boolean logicValue = false;
        WebElement webElement = driver.findElement(By.cssSelector(".tytul-obiekt"));
        String valueOfBase = webElement.getText();
        if (valueOfBase.equals("Baza Paliw nr 1 w Koluszkach")) {
            logicValue = true;
        }
        return logicValue;
    }

}
