package POMTests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FuelServicesTests extends BaseTest{


    @Test
    public void copyKoluszkiBaseAddress() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToFuelServicesPage().clickOnSelectedBase(774, 305, ".//a[@class = 'locations-map-list__url' and @href = 'https://www.pern.pl/obiekty/baza-paliw-nr-1-w-koluszkach/']");
        BasesLocationDetailsPage basesLocationDetailsPage = new BasesLocationDetailsPage(driver);
        String value = basesLocationDetailsPage.copyBaseAddress();
        Assertions.assertEquals("ul. Naftowa 1, 95-040 Koluszki, powiat łódzki-wschodni, województwo łódzkie", value, "String value is not the same as needed");
    }
    @Test
    public void goToFuelsPageAndClickOnKoluszkiBase(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToFuelServicesPage().clickOnSelectedBase(774, 305, ".//a[@class = 'locations-map-list__url' and @href = 'https://www.pern.pl/obiekty/baza-paliw-nr-1-w-koluszkach/']");
        Assertions.assertEquals("https://www.pern.pl/obiekty/baza-paliw-nr-1-w-koluszkach/", driver.getCurrentUrl(), "URL of website is incorrect");
    }

    @Test
    public void searchPhraseInSearcherFromTheHeader() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSearcher();
        mainPage.typeInSomeText("Usługi ochrony osób i mienia oraz ochrony przeciwpożarowej");
        Assertions.assertEquals("https://www.pern.pl/?s=Us%C5%82ugi+ochrony+os%C3%B3b+i+mienia+oraz+ochrony+przeciwpo%C5%BCarowej", driver.getCurrentUrl(), "The URL is not correct");
        Thread.sleep(3000);
    }
    @Test
    public void goToLaboratoryPageAndCheckDieselFlashPointValue() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        LaboratoryServicesPage laboratoryServicesPage = new LaboratoryServicesPage(driver);
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        FuelsAndBiocomponentsRequirementsPage fuelsAndBiocomponentsRequirementsPage = new FuelsAndBiocomponentsRequirementsPage(driver);
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();
    }
    @Test
    public void goToYoutubeWebPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnYT();
        YoutubePage youtubePage = new YoutubePage(driver);
        youtubePage.closeCookiesBtn();
        Assertions.assertEquals("https://www.youtube.com/channel/UCJnkxHoJhVynx-jXjv6OaRg", driver.getCurrentUrl(), "The url is not correct");
    }
}
