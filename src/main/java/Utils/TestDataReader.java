package Utils;

import java.util.Properties;

public class TestDataReader extends FileReader {

    private Properties properties;
    private Section mainViewURLValue;
    private final String testDataLocation;
    private Http pernAddressInputValue;
    private Http youTubeURLValue;

    private Http linkedInURLValue;
    private Phrase mainPageSearchExpression;
    private final Section mainPageViewURL;

    private final Phrase mainPageSearchValue;

    public TestDataReader(String testDataLocation, Section baseLocation, Http pernAddressInputValue, Http youTubeURLValue, Phrase searchSafetyPhrase, Section mainPageViewURL, Http linkedInURLValue, Phrase mainPageSearchValue) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
        this.mainViewURLValue = baseLocation;
        this.pernAddressInputValue = pernAddressInputValue;
        this.youTubeURLValue = youTubeURLValue;
        this.mainPageSearchExpression = searchSafetyPhrase;
        this.mainPageViewURL = mainPageViewURL;
        this.linkedInURLValue = linkedInURLValue;
        this.mainPageSearchValue = mainPageSearchValue;
    }

    public Section getMainSectionURL() {
        return mainViewURLValue;
    }

    public Http getPernAddressInputValue() {
        return pernAddressInputValue;
    }

    public Http getYouTubeURLValue() {
        return youTubeURLValue;
    }

    public Phrase getMainPageSearchExpression() {
        return mainPageSearchExpression;
    }

    public Http getLinkedInURLValue() {
        return linkedInURLValue;
    }

    public Phrase getMainPageSearchValue() {
        return mainPageSearchValue;
    }
}

