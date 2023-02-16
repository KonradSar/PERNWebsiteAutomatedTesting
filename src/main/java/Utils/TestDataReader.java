package Utils;

import java.util.Properties;

public class TestDataReader extends FileReader {
    private Properties properties;
    private Section baseLocation;
    private String testDataLocation;

    public TestDataReader(String testDataLocation, Section baseLocation) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
        this.baseLocation = baseLocation;
    }

    @Override
    void loadData() {

    }

    public void loadData(Properties properties) {
        baseLocation = new Section(properties);

    }


    public String getTestDataLocation() {
        return testDataLocation;
    }

    public Section getSection() {
        return baseLocation;
    }
}

