package POMTests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void goToKoluszkiBaseDetailsPage() {
        //when
        mainPage.goToFuelServicesPage().selectKoluszkiBaseLocation();
        //then
        Assertions.assertTrue(basesLocationDetailsPage.isKoluszkiDetailDisplayed());
    }

    @Test
    public void isAnyResultOfSearch() {
        //given
        headerPage.clickOnSearchBtn();
        //when
        headerPage.searchInSomeText(testDataReader.getSearchSafetyPhrase().getSearchSafetyValueInPERN());
        //then
        Assertions.assertTrue(searchResultsPage.isAnyResultNumber());
    }

    @Test
    public void navigateToPlockLocation() {
        mainPage.scrollToBottomMap().clickOnPlockLocation();
        Assertions.assertEquals(testDataReader.getSection().getMainLocationSectionURL(), driver.getCurrentUrl());
        mainLocationPage.clickOnNavigateBtn();
        cookiesViewPage.closeCookiesBtn();
        String inputValueFromGoogleMapsPage = googleMapsPage.getSearchInputValue();
        Assertions.assertTrue(inputValueFromGoogleMapsPage.contains(testDataReader.getPernAddressInputValue().getAddress()));
    }

    @Test
    public void goToLaboratoryPageAndCheckDieselFlashPointValue() {
        //given
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        Assertions.assertEquals(testDataReader.getSection().getLaboratorySectionURL(), driver.getCurrentUrl());
        //when
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();
        //then
        Assertions.assertTrue(fuelsAndBiocomponentsRequirementsPage.isFlashPointCorrect());
    }

    //tests for displaying additional materials directly from PERN.pl website:
    @Test
    public void goToYouTubePernMaterialsStartingFromMainPage() {
        //when
        footerPage.clickOnYoutubeLogo();
        //then
        cookiesViewPage.closeCookiesBtn();
        Assertions.assertEquals(testDataReader.getYouTubeURLValue().getYouTubeURL(), driver.getCurrentUrl());
    }

    //testsForDropDownMenuBelow:
    @Test
    public void isRegionsNumberCorrect() {
        Assertions.assertTrue(mainPage.isRegionsRangeInDropDownCorrect());
    }

    @Test
    public void isTypeOfLocationsNumberCorrect() {
        Assertions.assertTrue(mainPage.isTypeOfLocationRangeCorrect());
    }

    @Test
    public void displayFuelBasesForSilesia() throws InterruptedException {
        mainPage.scrollToBottomMap().selectSilesiaDistrict().selectFuelBasesType().pressSearchGreenBtn();
        Assertions.assertTrue(mainPage.isNumberOfSilesiaFuelBasesCorrect());
    }

    @Test
    public void displayOilBasesForAllRegions() throws InterruptedException {
        mainPage.selectOilBasesType().pressSearchGreenBtn();
        Assertions.assertTrue(mainPage.isNumberOfOilBasesInPolandCorrect());
    }
}
