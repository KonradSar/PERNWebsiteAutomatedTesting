package POMTests;

import PageObjects.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static PageObjects.DistrictTypeDropdownOption.SILESIA_DISTRICT;
import static PageObjects.LocationTypeDropdownOption.FUEL_BASES;
import static PageObjects.LocationTypeDropdownOption.OIL_BASES;
import static junit.framework.Assert.assertTrue;

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
