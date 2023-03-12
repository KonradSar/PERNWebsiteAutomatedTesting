package POMTests;

import EndpointsConfig.FuelsAndBiocomponentsRequirementsEndpoint;
import EndpointsConfig.MainPageEndpoint;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITests extends BaseAPITest {

    @Test
    public void goToFuelsAndBiocomponentRequirementsPage() {
        // When
        FuelsAndBiocomponentsRequirementsEndpoint fuelsAndBiocomponentsRequirementsEndpoint = new FuelsAndBiocomponentsRequirementsEndpoint();

        // Then
        Assertions.assertEquals(200, fuelsAndBiocomponentsRequirementsEndpoint.openFuelsAndBiocomponentsRequirementsPage().statusCode());
    }

    @Test
    public void goToMainPage() {
        // When
        MainPageEndpoint mainPageEndpoint = new MainPageEndpoint();

        // Then
        Assertions.assertEquals(200, mainPageEndpoint.openMainPage().statusCode());
    }

    @Test
    public void goToFuelsAndReqPageSimpleMethod() {
        Response response = given()
                .when()

                .get(testDataReader.getMainSectionURL().getLaboratoryURL());

        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void goToMainPageSimpleMethod() {
        Response response = given()
                .when()
                .get(testDataReader.getMainSectionURL().getMainSectionURL());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.statusCode());
    }
}
