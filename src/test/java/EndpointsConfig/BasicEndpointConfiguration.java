package EndpointsConfig;

import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

public abstract class BasicEndpointConfiguration {
    protected static String baseURL = "https://www.pern.pl/";
    protected Response lastResponse;

    public void setLastResponse(Response lastResponse) {
        this.lastResponse = lastResponse;
    }

    public Response getLastResponse() {
        return lastResponse;
    }

    public BasicEndpointConfiguration() {
        baseURI = baseURL;
    }

}
