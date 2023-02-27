package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TelecomunicationServicesPage extends BasePage {
    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;

    protected TelecomunicationServicesPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }
}
