package Utils;

import java.util.Properties;

public class Section {
    private final String laboratorySectionURL;
    private final String mainLocationSectionURL;
    private final String mainSectionURL;


    public Section(Properties properties) {
        laboratorySectionURL = properties.getProperty("baseURL") + properties.getProperty("section.sectionLaboratoryURL");
        mainLocationSectionURL = properties.getProperty("baseURL") + properties.getProperty("section.sectionMainLocationURL");
        mainSectionURL = properties.getProperty("baseURL");
    }

    public String getLaboratoryURL() {
        return laboratorySectionURL;
    }

    public String getMainLocationURL() {
        return mainLocationSectionURL;
    }

    public String getMainSectionURL() {
        return mainSectionURL;
    }
}
