package Utils;

import java.util.Properties;

public class Section {
    private final String sectionURL;

    public Section(Properties properties) {

        sectionURL = properties.getProperty("section.sectionURL");
    }

    public String getSectionURL() {
        return sectionURL;
    }
}
