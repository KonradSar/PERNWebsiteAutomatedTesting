package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.FuelsAndBiocomponentsRequirementsPage;
import page.objects.LaboratoryServicesPage;
import page.objects.MainPage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FuelsAndOilsParameterTests extends BaseTest {
    MainPage mainPage;
    LaboratoryServicesPage laboratoryServicesPage;
    FuelsAndBiocomponentsRequirementsPage fuelsAndBiocomponentsRequirementsPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
        laboratoryServicesPage = new LaboratoryServicesPage(driver);
        fuelsAndBiocomponentsRequirementsPage = new FuelsAndBiocomponentsRequirementsPage(driver);
    }

    @Test
    public void When_DeselFuelIsClicked_Expect_FlashPointValueIsDisplayed() {
        // Given
        mainPage.scrollToServicesTitle().goToLaboratoryServicesPage();
        laboratoryServicesPage.goToFuelsAndBiocomponentsRequirementsPage();
        assertEquals(testDataReader.getSectionAddress().getLaboratorySectionURL(), driver.getCurrentUrl());

        // When
        fuelsAndBiocomponentsRequirementsPage.clickOnDieseBtn().scrollToFlashPointTableValue();

        // Then
        assertTrue(fuelsAndBiocomponentsRequirementsPage.isFlashPointCorrect());
    }
}
