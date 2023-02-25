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
    private final HeaderPage headerPage;
    private final FooterPage footerPage;
    private final WebDriverWait webDriverWait;
    private final By pernFuelsTab = By.xpath(".//div[contains(@class, 'p-uslugi-wrapper')]//a[@href= 'https://www.pern.pl/uslugi/paliwa/']");
    private final By oilTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/ropa/']/img");
    private final By laboratoryTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/labolatorium/']/img");
    private final By cdokTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/cdok/']/img");
    private final By streamCalibrationsTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/wzorcowanie-przeplywomierzy/']/img");
    private final By telecommunicationTab = By.xpath(".//a[@class = 'p-uslugi__item ended' and @href = 'https://www.pern.pl/uslugi/telekomunikacja/']/img");

    private final By servicesSectionTitle = By.xpath(".//h2[@class='section__title']");

    private final By map = By.xpath(".//span[@class='locations-list__item-value']");

    private final By plockLocation = By.cssSelector("#siedziba_Mazowieckie_siedziba_spółki circle");

    private final By plockLabel = By.xpath(".//div[@class='locations-map-list__single locations-map-list__single--active']//a[@href='https://www.pern.pl/obiekty/siedziba-pern/']");

    private final By dropDownMenuRegions = By.cssSelector("#regions");

    private final By dropDownMenuTypeOfLocations = By.cssSelector("#locations");

    private final By searchGreenBtn = By.xpath(".//button[@class='green-button green-button--second locations-form__button button']");

    private final By changeLanguageBtn = By.cssSelector(".language-switcher");

    private final By languageSwitcher = By.xpath(".//div[@class='language-switcher language-switcher--active']");

    private final By englishLanguageBtn = By.cssSelector(".language-switcher a[href='https://www.pern.pl/en/']");


    public MainPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public FuelServicesPage goToFuelServicesPage() {
        var liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pernFuelsTab));
        liquidFuelsTab.click();
        return new FuelServicesPage(driver);

    }

    public OilServicesPage goToOilServicesPage() {
        var oilServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(oilTab));
        oilServicesTab.click();
        return new OilServicesPage(driver);

    }

    public MainPage scrollToServicesTitle() {
        var servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(servicesSectionTitle));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", servicesTitle);
        return new MainPage(driver);
    }

    public MainPage scrollToBottomMap() {
        var servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(map));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", servicesTitle);
        return new MainPage(driver);
    }

    public MainPage clickOnPlockLocation() {
        Actions actions = new Actions(driver);
        var location = driver.findElement(plockLocation);
        actions.moveToElement(location).click().build().perform();
        var pernLabel = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(plockLabel));
        pernLabel.click();
        return new MainPage(driver);
    }

    public MainPage selectSilesiaDistrict() {
        var dropDownCategories = driver.findElement(dropDownMenuRegions);
        Select categoriesDropdown = new Select(dropDownCategories);
        categoriesDropdown.selectByIndex(12);
        return new MainPage(driver);
    }

    public MainPage selectFuelBasesType() {
        var dropDownCategories = driver.findElement(dropDownMenuTypeOfLocations);
        Select categoriesDropdown = new Select(dropDownCategories);
        categoriesDropdown.selectByIndex(4);
        return new MainPage(driver);
    }

    public MainPage selectOilBasesType() {
        var dropDownCategories = driver.findElement(dropDownMenuTypeOfLocations);
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
        var laboratoryTabb = webDriverWait.until(ExpectedConditions.elementToBeClickable(laboratoryTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(laboratoryTabb).click().build().perform();
        return new LaboratoryServicesPage(driver);

    }

    public CDOKServicesPage goToCDOKServicesPage() {
        var cdokServicesTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cdokTab));
        cdokServicesTab.click();
        return new CDOKServicesPage(driver);

    }

    public StreamCalibrationServicesPage goToStreamCalibrationsServicesPage() {
        var liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(streamCalibrationsTab));
        liquidFuelsTab.click();
        return new StreamCalibrationServicesPage(driver);

    }

    public TelecomunicationServicesPage goToTelecommunicationServicesPage() {
        var liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(telecommunicationTab));
        liquidFuelsTab.click();
        return new TelecomunicationServicesPage(driver);
    }

    public boolean isRegionsRangeInDropDownCorrect() {
        boolean logicValue = false;
        var dropDownRegionCategories = driver.findElement(dropDownMenuRegions);
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
        var dropDownLocationsCategories = driver.findElement(dropDownMenuTypeOfLocations);
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
