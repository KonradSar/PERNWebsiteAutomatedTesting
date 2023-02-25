package Utils;

import java.util.Properties;

public class Strings {
    private final String pernAddressValue;
    private final String youTubeURL;

    private final String searchSafetyValueInPERN;

    public Strings(Properties properties) {
        pernAddressValue = properties.getProperty("strings.plockLocationURL");
        youTubeURL = properties.getProperty("strings.youTubeURL");
        searchSafetyValueInPERN = properties.getProperty("strings.searchInPERNSafetyValue");
    }

    public String getAddress() {
        return pernAddressValue;
    }

    public String getYouTubeURL() {
        return youTubeURL;
    }

    public String getSearchSafetyValueInPERN() {
        return searchSafetyValueInPERN;
    }
}
