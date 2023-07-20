package utils;


import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder(toBuilder = true)
public class TestDataReader extends FileReader {

    private final Section sectionAddress;
    private final String testDataLocation;
    private final Http googleMapsAddress;
    private final Http youTubeAddress;
    private final Http linkedInAddress;
    private final Phrase mainPageSearchExpression;
    private final Http twitterAddress;

    public TestDataReader(String testDataLocation, Section sectionAddress, Http googleMapsAddress,
                          Http youTubeAddress, Http linkedInAddress,
                          Phrase mainPageSearchExpression, Http twitterAddress) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
        this.sectionAddress = sectionAddress;
        this.googleMapsAddress = googleMapsAddress;
        this.youTubeAddress = youTubeAddress;
        this.mainPageSearchExpression = mainPageSearchExpression;
        this.linkedInAddress = linkedInAddress;
        this.twitterAddress = twitterAddress;
    }

    public Section getSectionAddress() {
        return sectionAddress;
    }

    public Http getGoogleMapsAddress() {
        return googleMapsAddress;
    }

    public Http getYouTubeAddress() {
        return youTubeAddress;
    }

    public Phrase getMainPageSearchExpression() {
        return mainPageSearchExpression;
    }

    public Http getLinkedInAddress() {
        return linkedInAddress;
    }

    public Http getTwitterAddress() {
        return twitterAddress;
    }
}
