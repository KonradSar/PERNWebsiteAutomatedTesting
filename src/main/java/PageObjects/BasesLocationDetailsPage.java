package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasesLocationDetailsPage extends BasePage{
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    private By locationOfBase = By.cssSelector("table[class$='table-striped']>tbody>tr:nth-child(3)>td");

    public BasesLocationDetailsPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public String copyBaseAddress(){
        WebElement addressRow = driver.findElement(locationOfBase);
        String value = addressRow.getText();
        return value;
    }

}
