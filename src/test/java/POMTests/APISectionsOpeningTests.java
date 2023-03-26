package POMTests;

import EndpointsConfig.Requests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class APISectionsOpeningTests extends BaseAPITest {

    @Test
    public void When_FuelsAndBiocomponentRequirementsTabIsClicked_Expect_FuelsAndBiocomponentRequirementsPageIsDisplayed() {
        // When
        Requests requests = new Requests();

        // Then
        Assertions.assertEquals(200, requests.getFuelsAndBiocomponents().statusCode());
    }

    @Test
    public void When_PERNPageIsLoaded_Expect_MainPageDetailsIsDisplayed() {
        // When
        Requests requests = new Requests();

        // Then
        Assertions.assertEquals(200, requests.getMainPage().statusCode());
    }
}
