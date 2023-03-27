package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.CustomWebElementActions.scrollToElement;

public class MainPage extends BasePage {
    private final HeaderSection headerSection;
    private final FooterSection footerSection;
    private final WebDriverWait webDriverWait;
    private final static int NUMBER_OF_SILESIA_FUEL_BASES = 4;
    private final static int NUMBER_OF_LOCATIONS = 6;
    private final static int NUMBER_OF_POLAND_OIL_BASES = 3;
    private final static int REGIONS_RANGE = 17;
    private final static String ALL_FUELBASES_CLICKABLE_SELECTOR = "#baza_paliw >g[id^='Baza']:not([style$='display: none;'])";
    private final static String ALL_OILBASES_CLICKABLE_SELECTOR = "#magazyny_ropy_naftowej >:not([style$='display: none;']";
    private final By pernFuelsTab = By.xpath(".//div[contains(@class, 'p-uslugi-wrapper')]//a[@href= 'https://www.pern.pl/uslugi/paliwa/']");
    private final By laboratoryTab = By.cssSelector(".animation a:nth-child(3)");
    private final By servicesSectionTitle = By.cssSelector(".section__title");
    protected final By servicesLinkTextENLanguageVersion = By.cssSelector("#menu-item-25948>a");
    protected final By servicesLinkTextDELanguageVersion = By.cssSelector("#menu-item-25924");
    public final By map = By.cssSelector(".locations-list li:nth-child(1)");
    private final By plockLocation = By.cssSelector("#siedziba_Mazowieckie_siedziba_spółki circle");
    private final By plockLabel = By.cssSelector(".locations-map-list__single--active div a");
    private final By dropDownMenuRegions = By.cssSelector("#regions");
    private final By dropDownMenuTypeOfLocations = By.cssSelector("#locations");
    private final By searchGreenBtn = By.cssSelector(".green-button--second");
    private final By changeLanguageBtn = By.cssSelector(".language-switcher");
    private final By languageSwitcher = By.cssSelector("div.language-switcher--active");
    private final By englishLanguageBtn = By.cssSelector(".language-switcher li:nth-child(1)");
    private final By deutschLanguageBtn = By.cssSelector(".language-switcher li:nth-child(2)");

    public MainPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public FuelServicesPage goToFuelServicesPage() {
        var liquidFuelsTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(pernFuelsTab));
        liquidFuelsTab.click();
        return new FuelServicesPage(driver);
    }

    public MainPage scrollToServicesTitle() {
        var servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(servicesSectionTitle));
        scrollToElement(servicesTitle, driver);
        return new MainPage(driver);
    }

    public MainPage scrollToBottomMap() {
        var servicesTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(map));
        scrollToElement(servicesTitle, driver);
        return new MainPage(driver);
    }

    public MainPage clickOnPlockLocation() {
        Actions actions = new Actions(driver);
        var location = driver.findElement(plockLocation);
        actions.moveToElement(location).click().build().perform();
        driver.findElement(plockLabel).click();
        return new MainPage(driver);
    }

    public void displayFuelBasesForSilesia(LocationTypeDropdownOption typeOfLocation, DistrictTypeDropdownOption districtOption) {
        driver.findElement(typeOfLocation.typeOfLocationLocator).click();
        driver.findElement(districtOption.districtTypeLocator).click();
        driver.findElement(searchGreenBtn).click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(ALL_FUELBASES_CLICKABLE_SELECTOR)));
    }

    public MainPage displayOilBasesForAllRegions(LocationTypeDropdownOption typeOfLocation) {
        driver.findElement(typeOfLocation.typeOfLocationLocator).click();
        driver.findElement(searchGreenBtn).click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(ALL_OILBASES_CLICKABLE_SELECTOR)));
        return new MainPage(driver);
    }

    public MainPage changeLanguageToEN() {
        driver.findElement(changeLanguageBtn).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(languageSwitcher));
        driver.findElement(englishLanguageBtn).click();
        return new MainPage(driver);
    }

    public MainPage changeLanguageToDE() {
        driver.findElement(changeLanguageBtn).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(languageSwitcher));
        driver.findElement(deutschLanguageBtn).click();
        return new MainPage(driver);
    }

    public LaboratoryServicesPage goToLaboratoryServicesPage() {
        var laboratoryTabb = webDriverWait.until(ExpectedConditions.elementToBeClickable(laboratoryTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(laboratoryTabb).click().build().perform();
        return new LaboratoryServicesPage(driver);
    }

    public boolean isRegionsRangeInDropDownCorrect() {
        var dropDownRegionCategories = driver.findElement(dropDownMenuRegions);
        Select categoriesDropdown = new Select(dropDownRegionCategories);
        List<WebElement> regionsList = categoriesDropdown.getOptions();
        return (regionsList.size() == REGIONS_RANGE);
    }

    public boolean isTypeOfLocationRangeCorrect() {
        var dropDownLocationsCategories = driver.findElement(dropDownMenuTypeOfLocations);
        Select categoriesDropdown = new Select(dropDownLocationsCategories);
        List<WebElement> locationsList = categoriesDropdown.getOptions();
        return (locationsList.size() == NUMBER_OF_LOCATIONS);
    }

    public boolean isNumberOfSilesiaFuelBasesCorrect() {
        List<WebElement> listOfLocationsFiltered = driver.findElements(By.cssSelector(ALL_FUELBASES_CLICKABLE_SELECTOR));
        return (listOfLocationsFiltered.size() == NUMBER_OF_SILESIA_FUEL_BASES);
    }

    public boolean isNumberOfOilBasesInPolandCorrect() {
        List<WebElement> listOfOilBases = driver.findElements(By.cssSelector(ALL_OILBASES_CLICKABLE_SELECTOR));
        return (listOfOilBases.size() == NUMBER_OF_POLAND_OIL_BASES);
    }

    public String getServicesLinkTextENLanguagePageVersion() {
        var servicesWebElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(servicesLinkTextENLanguageVersion));
        return servicesWebElement.getText();
    }

    public String getServicesLinkTextDELanguagePageVersion() {
        var servicesWebElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(servicesLinkTextDELanguageVersion));
        return servicesWebElement.getText();
    }
}
