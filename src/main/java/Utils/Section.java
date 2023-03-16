package Utils;

import java.util.Properties;

public class Section {
    private final String laboratorySectionURL;
    private final String mainLocationSectionURL;

    public Section(Properties properties) {
        laboratorySectionURL = properties.getProperty("baseURL") + properties.getProperty("section.sectionLaboratoryURL");
        mainLocationSectionURL = properties.getProperty("baseURL") + properties.getProperty("section.sectionMainLocationURL");
    }

    public String getLaboratorySectionURL() {
        return laboratorySectionURL;
    }

    public String getMainLocationSectionURL() {
        return mainLocationSectionURL;
    }
}
