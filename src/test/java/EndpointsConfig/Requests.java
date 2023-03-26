package EndpointsConfig;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class Requests extends BasicEndpointConfiguration {
    private final String FUELS_AND_BIOCOMPONENTS_ENDPOINT = "uslugi/laboratorium/wymagania-dla-paliw-i-biokomponentow/";
    private final String MAIN_PAGE_ENDPOINT = "";

    public Response getFuelsAndBiocomponents() {
        return lastResponse = get(FUELS_AND_BIOCOMPONENTS_ENDPOINT);
    }

    public Response getMainPage() {
        return lastResponse = get(MAIN_PAGE_ENDPOINT);
    }
}
