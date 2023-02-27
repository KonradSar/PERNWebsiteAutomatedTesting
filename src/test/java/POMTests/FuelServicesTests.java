package POMTests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FuelServicesTests extends BaseTest {
    HeaderPage headerPage;
    MainPage mainPage;
    BasesLocationDetailsPage basesLocationDetailsPage;
    SearchResultsPage searchResultsPage;
    LaboratoryServicesPage laboratoryServicesPage;
    FuelsAndBiocomponentsRequirementsPage fuelsAndBiocomponentsRequirementsPage;

    MainLocationPage mainLocationPage;
    FooterPage footerPage;
    CookiesViewPage cookiesViewPage;

    GoogleMapsPage googleMapsPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
        basesLocationDetailsPage = new BasesLocationDetailsPage(driver);
        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        laboratoryServicesPage = new LaboratoryServicesPage(driver);
        fuelsAndBiocomponentsRequirementsPage = new FuelsAndBiocomponentsRequirementsPage(driver);
        mainLocationPage = new MainLocationPage(driver);
        footerPage = new FooterPage(driver);
        cookiesViewPage = new CookiesViewPage(driver);
        googleMapsPage = new GoogleMapsPage(driver);
    }


    @Test
    public void goToKoluszkiBaseDetailsPage(){
        // When
        mainPage.goToFuelServicesPage().selectKoluszkiBaseLocation();

        // Then
        assertTrue(basesLocationDetailsPage.isKoluszkiDetailDisplayed());
    }

    @Test
    public void isAnyResultOfSearch() {
        // Given
        headerPage.clickOnSearchBtn();

        // When
        headerPage.searchInSomeText(testDataReader.getSearchSafetyPhrase().getSearchSafetyValueInPERN());

        // Then
        assertTrue(searchResultsPage.isAnyResultNumber());
    }

    @Test
    public void searchPlockLocationInGoogleMaps() {
        // Given
        mainPage.scrollToBottomMap().clickOnPlockLocation();
        Assertions.assertEquals(testDataReader.getSection().getMainLocationSectionURL(), driver.getCurrentUrl());
        mainLocationPage.clickOnNavigateBtn();
        cookiesViewPage.closeCookiesBtn();

        // When
        String inputValueFromGoogleMapsPage = googleMapsPage.getSearchInputValue();

        // Then
        assertTrue(inputValueFromGoogleMapsPage.contains(testDataReader.getPernAddressInputValue().getAddress()));
    }

    @Test
    public void goToLaboratoryPageAndCheckDieselFlashPointValue() {
        // Given
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        assertEquals(testDataReader.getSection().getLaboratorySectionURL(), driver.getCurrentUrl());

        // When
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();

        // Then
        assertTrue(fuelsAndBiocomponentsRequirementsPage.isFlashPointCorrect());
    }

    //tests for displaying additional materials directly from PERN.pl website:
    @Test
    public void goToYouTubePernMaterialsStartingFromMainPage() {
        // When
        footerPage.clickOnYoutubeLogo();
        cookiesViewPage.closeCookiesBtn();

        // Then
        assertEquals(testDataReader.getYouTubeURLValue().getYouTubeURL(), driver.getCurrentUrl());
    }

    //testsForDropDownMenuBelow:
    @Test
    public void isRegionsNumberCorrect() {
        assertTrue(mainPage.isRegionsRangeInDropDownCorrect());
    }

    @Test
    public void isTypeOfLocationsNumberCorrect() {
        assertTrue(mainPage.isTypeOfLocationRangeCorrect());
    }

    @Test
    public void displayFuelBasesForSilesia() throws InterruptedException {
        // When
        mainPage.scrollToBottomMap().selectSilesiaDistrict().selectFuelBasesType().pressSearchGreenBtn();

        // Then
        assertTrue(mainPage.isNumberOfSilesiaFuelBasesCorrect());
    }

    @Test
    public void displayOilBasesForAllRegions() throws InterruptedException {
        // When
        mainPage.selectOilBasesType().pressSearchGreenBtn();

        // Then
        assertTrue(mainPage.isNumberOfOilBasesInPolandCorrect());
    }
    @Test
    public void checkLanguageToEN(){
        // When
        mainPage.changeLanguageToEN();

        // Then
        assertTrue(driver.getPageSource().contains("lang=\"en-US\""));
    }
}
