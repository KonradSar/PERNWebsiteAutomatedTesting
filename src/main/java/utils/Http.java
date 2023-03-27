package utils;

import java.util.Properties;

public class Http {
    private final String pernAddressValue;
    private final String youTubeURL;

    private final String linkedInURL;

    private final String twitterURL;

    public Http(Properties properties) {
        pernAddressValue = properties.getProperty("http.plockLocationURL");
        youTubeURL = properties.getProperty("http.youTubeURL");
        linkedInURL = properties.getProperty("http.linkedInURL");
        twitterURL = properties.getProperty("http.twitterURL");
    }

    public String getGoogleMapsURL() {
        return pernAddressValue;
    }

    public String getTwitterURL() {return twitterURL;}

    public String getYouTubeURL() {
        return youTubeURL;
    }

    public String getLinkedInURL() {
        return linkedInURL;
    }
}
