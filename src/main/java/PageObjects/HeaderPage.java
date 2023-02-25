package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage extends BasePage {
    private final WebDriverWait webDriverWait;

    public HeaderPage(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    private final By pernLogo = By.xpath(".//a[@class = 'navbar-brand']/img");
    private final By mainPageLink = By.xpath(".//li[@id = 'menu-item-2482']/a");
    private final By aboutUsLink = By.xpath(".//li[@id = 'menu-item-2483']/a");
    private final By pressOfficeLink = By.xpath(".//li[@id = 'menu-item-2509']/a");
    private final By servicesLink = By.xpath(".//li[@id = 'menu-item-2514']/a");
    private final By contactUsLink = By.xpath(".//li[@id = 'menu-item-2559']/a");
    private final By searchBtn = By.xpath(".//li[@class = 'menu-item menu-item--search']/div");
    private final By cdokContactLink = By.xpath(".//li[@id= 'menu-item-3927']/a");
    private final By shoppingPlatform = By.xpath(".//li[@id= 'menu-item-3138']/a");
    private final By changeLanguageBtn = By.xpath(".//button[@class= 'language-switcher__current']");

    private final By textInput = By.xpath(".//input[@class='search-modal__input field form-control']");

    public MainPage clickOnMainPageLinkText() {
        driver.findElement(mainPageLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnPERNLogo() {
        driver.findElement(pernLogo).click();
        return new MainPage(driver);
    }

    public MainPage clickOnAboutUsLinkText() {
        driver.findElement(aboutUsLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnPressOfficeLinkText() {
        driver.findElement(pressOfficeLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnServicesLinkText() {
        driver.findElement(servicesLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnContactUsLinkText() {
        driver.findElement(contactUsLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnSearchBtn() {
        driver.findElement(searchBtn).click();
        return new MainPage(driver);
    }

    public MainPage clickOnCDOKContactLinkText() {
        driver.findElement(cdokContactLink).click();
        return new MainPage(driver);
    }

    public MainPage clickOnShoppingPlatformLinkText() {
        driver.findElement(shoppingPlatform).click();
        return new MainPage(driver);
    }

    public MainPage clickOnChangeLanguageLinkText() {
        driver.findElement(changeLanguageBtn).click();
        return new MainPage(driver);
    }

    public MainPage searchInSomeText(String phrase) {
        var searchInput = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(textInput));
        searchInput.sendKeys(phrase);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).build().perform();
        return new MainPage(driver);
    }


}
