package page.objects;

import org.openqa.selenium.WebDriver;

public class FooterSection extends BasePage {
    public FooterSection(WebDriver driver) {
        super(driver);
    }
    public void openTabElement(FooterTab footerTab) {
        driver.findElement(footerTab.tabLocator).click();
    }
}
