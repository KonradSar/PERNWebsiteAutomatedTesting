package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    private HeaderPage headerPage;
    private FooterPage footerPage;
    private WebDriverWait webDriverWait;
    private By pernFuelsTab = By.xpath(".//div[contains(@class, 'p-uslugi-wrapper')]//a[@href= 'https://www.pern.pl/uslugi/paliwa/']");
    private By oilTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/ropa/']/img");
    private By laboratoryTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/labolatorium/']/img");
    private By cdokTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/cdok/']/img");
    private By streamCalibrationsTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/wzorcowanie-przeplywomierzy/']/img");
    private By telecommunicationTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/telekomunikacja/']/img");

    private By servicesSectionTitle = By.xpath(".//h2[@class='section__title']");

    private By map = By.xpath(".//span[@class='locations-list__item-value']");

    private By plockLocation = By.cssSelector("#siedziba_Mazowieckie_siedziba_spółki circle");

    private By plockLabel = By.xpath(".//div[@class='locations-map-list__single locations-map-list__single--active']//a[@href='https://www.pern.pl/obiekty/siedziba-pern/']");

    private By dropDownMenuRegions = By.cssSelector("#regions");

    private By dropDownMenuTypeOfLocations = By.cssSelector("#locations");

    private By searchGreenBtn = By.xpath(".//button[@class='green-button green-button--second locations-form__button button']");

    private By changeLanguageBtn = By.cssSelector(".language-switcher");

    private By languageSwitcher = By.xpath(".//div[@class='language-switcher language-switcher--active']");

    private By englishLanguageBtn = By.cssSelector(".language-switcher a[href='https://www.pern.pl/en/']");


    public MainPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(17));
    }

    public FuelServicesPage goToFuelServicesPage() {
        WebElement liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pernFuelsTab));
        liquidFuelsTab.click();
        return new FuelServicesPage(driver);

    }

    public OilServicesPage goToOilServicesPage() {
        WebElement oilServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(oilTab));
        oilServicesTab.click();
        return new OilServicesPage(driver);

    }

    public MainPage scrollToServicesTitle() {
        WebElement servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(servicesSectionTitle));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", servicesTitle);
        return new MainPage(driver);
    }

    public MainPage scrollToBottomMap() {
        WebElement servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(map));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", servicesTitle);
        return new MainPage(driver);
    }

    public MainPage clickOnPlockLocation() {
        Actions actions = new Actions(driver);
        WebElement location = driver.findElement(plockLocation);
        actions.moveToElement(location).click().build().perform();
        WebElement pernLabel = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(plockLabel));
        pernLabel.click();
        return new MainPage(driver);
    }

    public MainPage selectSilesiaDistrict() {
        WebElement dropDownCategories = driver.findElement(dropDownMenuRegions);
        Select categoriesDropdown = new Select(dropDownCategories);
        categoriesDropdown.selectByIndex(12);
        return new MainPage(driver);
    }

    public MainPage selectFuelBasesType() {
        WebElement dropDownCategories = driver.findElement(dropDownMenuTypeOfLocations);
        Select categoriesDropdown = new Select(dropDownCategories);
        categoriesDropdown.selectByIndex(4);
        return new MainPage(driver);
    }

    public MainPage selectOilBasesType() {
        WebElement dropDownCategories = driver.findElement(dropDownMenuTypeOfLocations);
        Select categoriesDropdown = new Select(dropDownCategories);
        categoriesDropdown.selectByIndex(3);
        return new MainPage(driver);
    }

    public MainPage pressSearchGreenBtn() throws InterruptedException {
        driver.findElement(searchGreenBtn).click();
        Thread.sleep(500);
        return new MainPage(driver);
    }

    public MainPage changeLanguageToEN() {
        driver.findElement(changeLanguageBtn).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(languageSwitcher));
        driver.findElement(englishLanguageBtn).click();
        return new MainPage(driver);
    }

    public LaboratoryServicesPage goToLaboratoryServicesPage() {
        WebElement laboratoryTabb = webDriverWait.until(ExpectedConditions.elementToBeClickable(laboratoryTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(laboratoryTabb).click().build().perform();
        return new LaboratoryServicesPage(driver);

    }

    public CDOKServicesPage goToCDOKServicesPage() {
        WebElement cdokServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cdokTab));
        cdokServicesTab.click();
        return new CDOKServicesPage(driver);

    }

    public StreamCalibrationServicesPage goToStreamCalibrationsServicesPage() {
        WebElement liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(streamCalibrationsTab));
        liquidFuelsTab.click();
        return new StreamCalibrationServicesPage(driver);

    }

    public TelecomunicationServicesPage goToTelecommunicationServicesPage() {
        WebElement liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(telecommunicationTab));
        liquidFuelsTab.click();
        return new TelecomunicationServicesPage(driver);
    }

    public boolean isRegionsRangeInDropDownCorrect() {
        boolean logicValue = false;
        WebElement dropDownRegionCategories = driver.findElement(dropDownMenuRegions);
        Select categoriesDropdown = new Select(dropDownRegionCategories);
        List<WebElement> regionsList = categoriesDropdown.getOptions();
        if (regionsList.size() == 17) {
            logicValue = true;
        } else {
            System.out.println("number of regions is " + regionsList.size());
        }
        return logicValue;
    }

    public boolean isTypeOfLocationRangeCorrect() {
        boolean logicValue = false;
        WebElement dropDownLocationsCategories = driver.findElement(dropDownMenuTypeOfLocations);
        Select categoriesDropdown = new Select(dropDownLocationsCategories);
        List<WebElement> locationsList = categoriesDropdown.getOptions();
        if (locationsList.size() == 6) {
            logicValue = true;
        } else {
            System.out.println("number of locations is " + locationsList.size());
        }
        return logicValue;
    }

    public boolean isNumberOfSilesiaFuelBasesCorrect() {
        boolean logicValue = false;
        List<WebElement> listOfLocationsFiltered = driver.findElements(By.cssSelector("#baza_paliw >g[id^='Baza']:not([style$='display: none;'])"));
        if (listOfLocationsFiltered.size() == 4) {
            logicValue = true;
        } else {
            System.out.println("number of elements is " + listOfLocationsFiltered.size());
        }
        return logicValue;
    }

    public boolean isNumberOfOilBasesInPolandCorrect() {
        boolean logicValue = false;
        List<WebElement> listOfOilBases = driver.findElements(By.cssSelector("#magazyny_ropy_naftowej >:not([style$='display: none;']"));
        if (listOfOilBases.size() == 3) {
            logicValue = true;
        } else {
            System.out.println("number of elements is " + listOfOilBases.size());
        }
        return logicValue;
    }


}
