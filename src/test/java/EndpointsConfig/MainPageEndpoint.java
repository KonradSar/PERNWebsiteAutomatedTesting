package EndpointsConfig;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class MainPageEndpoint extends BasicEndpointConfiguration {
    private final String mainPageEndpoint = "";

    public Response openMainPage() {
        return lastResponse = get(mainPageEndpoint);
    }
}
