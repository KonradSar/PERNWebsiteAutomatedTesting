package Utils;

import java.util.Properties;

public class TestDataReader extends FileReader {

    private Properties properties;
    private Section baseLocation;
    private final String testDataLocation;
    private Strings pernAddressValue;
    private Strings youTubeURLValue;
    private final Strings searchSafetyPhrase;
    private final Section mainPageViewURL;

    public TestDataReader(String testDataLocation, Section baseLocation, Strings pernAddressInputValue, Strings youTubeURLValue, Strings searchSafetyPhrase, Section mainPageViewURL) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
        this.baseLocation = baseLocation;
        this.pernAddressValue = pernAddressInputValue;
        this.youTubeURLValue = youTubeURLValue;
        this.searchSafetyPhrase = searchSafetyPhrase;
        this.mainPageViewURL = mainPageViewURL;
    }

    @Override
    void loadData() {
    }

    public void loadData(Properties properties) {
        baseLocation = new Section(properties);
        pernAddressValue = new Strings(properties);
        youTubeURLValue = new Strings(properties);
    }

    public String getTestDataLocation() {
        return testDataLocation;
    }

    public Section getSection() {
        return baseLocation;
    }

    public Strings getPernAddressInputValue() {
        return pernAddressValue;
    }

    public Strings getYouTubeURLValue() {
        return youTubeURLValue;
    }

    public Strings getSearchSafetyPhrase() {
        return searchSafetyPhrase;
    }

    public Section getMainPageViewURL() {
        return mainPageViewURL;
    }
}

