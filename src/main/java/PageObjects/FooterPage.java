package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage extends BasePage {
    public FooterPage(WebDriver driver) {
        super(driver);
    }

    private By contactInvestorLink = By.xpath(".//li[@id = 'menu-item-2614']/a");
    private By securityInfoForLocalCommunityLink = By.xpath(".//li[@id = 'menu-item-7252']/a");
    private By rodoLink = By.xpath(".//li[@id = 'menu-item-2606']/a");
    private By privacyPolicyLink = By.xpath(".//li[@id = 'menu-item-30']/a");
    private By cookiesPolicyLink = By.xpath(".//li[@id = 'menu-item-29']/a");
    private By publicInformationSheetLink = By.xpath(".//li[@id = 'menu-item-2603']/a");
    private By taxStrategyLink = By.xpath(".//li[@id = 'menu-item-2604']/a");
    private By companiesLintLink = By.xpath(".//li[@id = 'menu-item-2605']/a");
    private By zszPolicyLink = By.xpath(".//li[@id = 'menu-item-4832']/a");
    private By naftoportLogo = By.xpath(".//a[@href = 'https://naftoport.pl/']/img");
    private By siarkopolLogo = By.xpath(".//a[@href = 'http://siarkopol.gda.pl/']/img");
    private By naftorLogo = By.xpath(".//a[@href = 'https://naftor.pl/']/img");
    private By naftoservisLogo = By.xpath(".//a[@href = 'https://naftoserwis.pl/']/img");
    private By sarmatiaLogo = By.xpath(".//a[@href = 'https://sarmatia.com.pl/']/img");
    private By youTubeLogo = By.xpath(".//a[@href = 'https://www.youtube.com/channel/UCJnkxHoJhVynx-jXjv6OaRg']/img");
    private By linkedInLogo = By.xpath(".//a[@href = 'https://www.linkedin.com/company/pern-s-a/']/img");
    private By twitterLogo = By.xpath(".//a[@href = 'https://twitter.com/pern_sa']/img");

    public MainPage clickContactInvestorsLinkText() {
        driver.findElement(contactInvestorLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnInformationForLocalCommunityLinkText() {
        driver.findElement(securityInfoForLocalCommunityLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnRODOLinkText() {
        driver.findElement(rodoLink).click();
        return new MainPage(driver);
    }

    public MainPage clickPrivacyPolicyLinkText() {
        driver.findElement(privacyPolicyLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnCookiesPolicyLinkText() {
        driver.findElement(cookiesPolicyLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnPublicInformationSheetLinkText() {
        driver.findElement(publicInformationSheetLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnTaxStrategyLinkText() {
        driver.findElement(taxStrategyLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnCompaniesListLinkText() {
        driver.findElement(companiesLintLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnZSZPolicyLinkText() {
        driver.findElement(zszPolicyLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnNaftoportLogo() {
        driver.findElement(naftoportLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnSiarkopolLogo() {
        driver.findElement(siarkopolLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnNaftorLogo() {
        driver.findElement(naftorLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnSarmatiaLogo() {
        driver.findElement(sarmatiaLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnNaftoservisLogo() {
        driver.findElement(naftoservisLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnYoutubeLogo() {
        driver.findElement(youTubeLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnLinkedInLogo() {
        driver.findElement(linkedInLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnTwitterLogo() {
        driver.findElement(twitterLogo).click();
        return new MainPage(driver);
    }


}
