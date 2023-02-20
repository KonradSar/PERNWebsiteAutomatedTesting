package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaboratoryServicesPage extends BasePage {
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;

    private By fuelsAndBiocomponentsRequirementsTab = By.xpath(".//div[contains(@class, 'p-uslugi-wrapper')]//a[@href= 'https://www.pern.pl/uslugi/labolatorium/wymagania-dla-paliw/']");


    public LaboratoryServicesPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public FuelsAndBiocomponentsRequirementsPage goToFuelsAndBiocomponentsRequirementsPage() {
        WebElement requirementsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(fuelsAndBiocomponentsRequirementsTab));
        requirementsTab.click();
        return new FuelsAndBiocomponentsRequirementsPage(driver);

    }
}
