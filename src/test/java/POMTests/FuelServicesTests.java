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
    FooterPage footerPage;
    YoutubePage youtubePage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
        basesLocationDetailsPage = new BasesLocationDetailsPage(driver);
        headerPage = new HeaderPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        laboratoryServicesPage = new LaboratoryServicesPage(driver);
        fuelsAndBiocomponentsRequirementsPage = new FuelsAndBiocomponentsRequirementsPage(driver);
        footerPage = new FooterPage(driver);
        youtubePage = new YoutubePage(driver);
    }


    @Test
    public void goToKoluszkiBaseDetailsPage(){
        //when
        mainPage.goToFuelServicesPage().selectKoluszkiBaseLocation();
        //then
        Assertions.assertTrue(basesLocationDetailsPage.isKoluszkiDetailDisplayed());
    }

    @Test
    public void searchPhraseInSearcherFromTheHeader() {
        //given
        headerPage.clickOnSearchBtn();
        //when
        headerPage.searchInSomeText("Usługi ochrony osób i mienia oraz ochrony przeciwpożarowej");
        //then
        Assertions.assertTrue(searchResultsPage.isAnyResultNumber());

    }

    @Test
    public void goToLaboratoryPageAndCheckDieselFlashPointValue() {
        //given
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        Assertions.assertEquals(testDataReader.getSection().getSectionURL(), driver.getCurrentUrl());
        //when
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();
        //then
        Assertions.assertTrue(fuelsAndBiocomponentsRequirementsPage.isFlashPointCorrect());
    }

    @Test
    public void goToYouTubePernMaterialsStartingFromMainPage() {
        //when
        footerPage.clickOnYoutubeLogo();
        //then
        youtubePage.closeCookiesBtn();
        Assertions.assertEquals("https://www.youtube.com/channel/UCJnkxHoJhVynx-jXjv6OaRg", driver.getCurrentUrl());
    }
}
