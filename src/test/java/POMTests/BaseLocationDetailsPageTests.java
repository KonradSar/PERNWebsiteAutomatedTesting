package POMTests;

import PageObjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class BaseLocationDetailsPageTests extends BaseTest {

    MainPage mainPage;
    BasesLocationDetailsPage basesLocationDetailsPage;
    MainLocationPage mainLocationPage;
    CookiesSection cookiesSection;
    GoogleMapsPage googleMapsPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
        mainLocationPage = new MainLocationPage(driver);
        cookiesSection = new CookiesSection(driver);
        basesLocationDetailsPage = new BasesLocationDetailsPage(driver);
        googleMapsPage = new GoogleMapsPage(driver);
    }

    @Test
    public void When_KoluszkiFuelBaseLocationOnTheMapIsClicked_Expect_KoluszkiFuelBaseDetailsPageIsDisplayed() {
        // When
        mainPage.goToFuelServicesPage().selectKoluszkiBaseLocation();

        // Then
        assertTrue(basesLocationDetailsPage.isKoluszkiDetailDisplayed());
    }

    @Test
    public void When_NavigateToButtonIsClicked_Expect_GoogleMapsPageWithAddressValueIsDisplayed() {
        // When
        mainPage.scrollToBottomMap().clickOnPlockLocation();
        Assertions.assertEquals(testDataReader.getSectionAddress().getMainLocationSectionURL(), driver.getCurrentUrl());
        mainLocationPage.clickOnNavigateBtn();
        cookiesSection.closeYouTubeCookiesBtn();

        // Then
        assertTrue(googleMapsPage.getSearchInputValue().contains(testDataReader.getGoogleMapsAddress().getGoogleMapsURL()));
    }
}
