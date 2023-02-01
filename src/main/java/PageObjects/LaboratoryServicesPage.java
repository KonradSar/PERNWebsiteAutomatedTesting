package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaboratoryServicesPage extends BasePage{
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    protected LaboratoryServicesPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }
}
