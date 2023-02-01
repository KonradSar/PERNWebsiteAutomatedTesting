package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{
    protected HeaderPage(WebDriver driver) {
        super(driver);
    }
    private By pernLogo = By.xpath(".//a[@class = 'navbar-brand']/img");
    private By mainPageLink = By.xpath(".//li[@id = 'menu-item-2482']/a");
    private By aboutUsLink = By.xpath(".//li[@id = 'menu-item-2483']/a");
    private By pressOfficeLink = By.xpath(".//li[@id = 'menu-item-2509']/a");
    private By servicesLink = By.xpath(".//li[@id = 'menu-item-2514']/a");
    private By contactUsLink = By.xpath(".//li[@id = 'menu-item-2559']/a");
    private By searchBtn = By.xpath(".//li[@class = 'menu-item menu-item--search']/div");
    private By cdokContactLink = By.xpath(".//li[@id= 'menu-item-3927']/a");
    private By shoppingPlatform = By.xpath(".//li[@id= 'menu-item-3138']/a");
    private By changeLanguageBtn = By.xpath(".//button[@class= 'language-switcher__current']");

    public MainPage clickOnMainPageLinkText(){
        driver.findElement(mainPageLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnPERNLogo(){
        driver.findElement(pernLogo).click();
        return new MainPage(driver);
    }
    public MainPage clickOnAboutUsLinkText(){
        driver.findElement(aboutUsLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnPressOfficeLinkText(){
        driver.findElement(pressOfficeLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnServicesLinkText(){
        driver.findElement(servicesLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnContactUsLinkText(){
        driver.findElement(contactUsLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnSearchBtn(){
        driver.findElement(searchBtn).click();
        return new MainPage(driver);
    }
    public MainPage clickOnCDOKContactLinkText(){
        driver.findElement(cdokContactLink).click();
        return new MainPage(driver);
    }
    public MainPage clickOnShoppingPlatformLinkText(){
        driver.findElement(shoppingPlatform).click();
        return new MainPage(driver);
    }
    public MainPage clickOnChangeLanguageLinkText(){
        driver.findElement(changeLanguageBtn).click();
        return new MainPage(driver);
    }

}
