package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaboratoryServicesPage extends BasePage {
    private final HeaderSection headerSection;
    private final FooterSection footerSection;
    private final WebDriverWait webDriverWait;
    private final By fuelsAndBiocomponentsRequirementsTab = By.cssSelector(".justify-content-between a:nth-child(4)");

    public LaboratoryServicesPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public FuelsAndBiocomponentsRequirementsPage goToFuelsAndBiocomponentsRequirementsPage() {
        var requirementsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(fuelsAndBiocomponentsRequirementsTab));
        requirementsTab.click();
        return new FuelsAndBiocomponentsRequirementsPage(driver);
    }
}
