package EndpointsConfig;

import io.restassured.response.Response;
import static io.restassured.RestAssured.get;

public class FuelsAndBiocomponentsRequirementsEndpoint extends BasicEndpointConfiguration {
    private final String fuelsAndBiocomponentsEndpoint = "uslugi/laboratorium/wymagania-dla-paliw-i-biokomponentow/";

    public Response openFuelsAndBiocomponentsRequirementsPage() {
        return lastResponse = get(fuelsAndBiocomponentsEndpoint);
    }
}