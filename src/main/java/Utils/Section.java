package Utils;

import java.util.Properties;

public class Section {
    private final String laboratorySectionURL;
    private final String mainLocationSectionURL;
    private final String mainPageViewURL;


    public Section(Properties properties) {
        laboratorySectionURL = properties.getProperty("section.sectionLaboratoryURL");
        mainLocationSectionURL = properties.getProperty("section.sectionMainLocationURL");
        mainPageViewURL = properties.getProperty("section.sectionMainPageURL");
    }

    public String getLaboratorySectionURL() {
        return laboratorySectionURL;
    }

    public String getMainLocationSectionURL() {
        return mainLocationSectionURL;
    }

    public String getMainPageViewURL() {
        return mainPageViewURL;
    }
}
