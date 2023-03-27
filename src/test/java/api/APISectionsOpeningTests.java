package api;

import endpoints.config.FuelsAndBiocomponentsRequirementsEndpoint;
import endpoints.config.MainPageEndpoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class APISectionsOpeningTests extends BaseAPITest {

    @Test
    public void When_FuelsAndBiocomponentRequirementsTabIsClicked_Expect_FuelsAndBiocomponentRequirementsPageIsDisplayed() {
        // When
        FuelsAndBiocomponentsRequirementsEndpoint fuelsAndBiocomponentsRequirementsEndpoint = new FuelsAndBiocomponentsRequirementsEndpoint();

        // Then
        Assertions.assertEquals(200, fuelsAndBiocomponentsRequirementsEndpoint.openFuelsAndBiocomponentsRequirementsPage().statusCode());
    }

    @Test
    public void When_PERNPageIsLoaded_Expect_MainPageDetailsIsDisplayed() {
        // When
        MainPageEndpoint mainPageEndpoint = new MainPageEndpoint();

        // Then
        Assertions.assertEquals(200, mainPageEndpoint.openMainPage().statusCode());
    }
}
