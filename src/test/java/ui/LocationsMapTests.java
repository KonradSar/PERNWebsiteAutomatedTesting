package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.MainPage;

import static junit.framework.Assert.assertTrue;
import static page.objects.DistrictTypeDropdownOption.SILESIA_DISTRICT;
import static page.objects.LocationTypeDropdownOption.FUEL_BASES;
import static page.objects.LocationTypeDropdownOption.OIL_BASES;

public class LocationsMapTests extends BaseTest {
    MainPage mainPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void When_SilesiaRegionFuelBasesInDropDownMenusIsSelected_Expect_6LocationsOnTheMapIsDisplayed() {
        // When
        mainPage.scrollToBottomMap().displayFuelBasesForSilesia(FUEL_BASES, SILESIA_DISTRICT);

        // Then
        assertTrue(mainPage.isNumberOfSilesiaFuelBasesCorrect());
    }

    @Test
    public void When_OilBasesForAllRegionsInDropDownMenusIsSelected_Expect_3LocationsOnTheMapIsDisplayed() {
        // When
        mainPage.displayOilBasesForAllRegions(OIL_BASES);

        // Then
        assertTrue(mainPage.isNumberOfOilBasesInPolandCorrect());
    }
}
