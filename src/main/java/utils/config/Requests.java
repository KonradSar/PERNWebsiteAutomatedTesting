package utils.config;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class Requests extends BasicEndpointConfiguration {

    private final String fuelsAndBiocomponentsEndpoint = "uslugi/laboratorium/wymagania-dla-paliw-i-biokomponentow/";
    private final String mainPageEndpoint = "";

    public Response getMainPage() {
        return lastResponse = get(mainPageEndpoint);
    }

    public Response getFuelsAndBiocomponents() {
        return lastResponse = get(fuelsAndBiocomponentsEndpoint);
    }
    //test
}
