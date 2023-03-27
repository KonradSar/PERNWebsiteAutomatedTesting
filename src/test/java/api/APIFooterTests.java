package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APIFooterTests extends BaseAPITest {
    @Test
    public void When_TwitterIconIsClicked_Expect_TwitterWebPageIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getTwitterAddress().getTwitterURL());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void When_YouTubeIconIsClicked_Expect_YouTubeWebPageIsDisplayed() {
        Response response = given()
                .when()
                .get(testDataReader.getYouTubeAddress().getYouTubeURL());
        System.out.println(response.prettyPrint());
        Assertions.assertEquals(200, response.statusCode());
    }
}
