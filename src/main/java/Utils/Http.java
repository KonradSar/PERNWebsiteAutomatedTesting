package Utils;

import java.util.Properties;

public class Http {
    private final String pernAddressValue;
    private final String youTubeURL;

    private final String linkedInURL;

    public Http(Properties properties) {
        pernAddressValue = properties.getProperty("http.plockLocationURL");
        youTubeURL = properties.getProperty("http.youTubeURL");
        linkedInURL = properties.getProperty("http.linkedInURL");
    }

    public String getAddress() {
        return pernAddressValue;
    }

    public String getYouTubeURL() {
        return youTubeURL;
    }

    public String getLinkedInURL() {
        return linkedInURL;
    }
}
