package Utils;


public class TestDataReader extends FileReader {

    private Section sectionAddress;
    private final String testDataLocation;
    private Http googleMapsAddress;
    private Http youTubeAddress;
    private Http linkedInAddress;
    private Phrase mainPageSearchExpression;
    private final Http twitterAddress;
    private final Phrase mainPageSearchValue;

    public TestDataReader(String testDataLocation, Section sectionAddress, Http googleMapsAddress,
                          Http youTubeAddress, Phrase searchSafetyPhrase, Http linkedInAddress,
                          Phrase mainPageSearchValue, Http twitterAddress) {
        super(testDataLocation);
        this.testDataLocation = testDataLocation;
        this.sectionAddress = sectionAddress;
        this.googleMapsAddress = googleMapsAddress;
        this.youTubeAddress = youTubeAddress;
        this.mainPageSearchExpression = searchSafetyPhrase;
        this.linkedInAddress = linkedInAddress;
        this.mainPageSearchValue = mainPageSearchValue;
        this.twitterAddress = twitterAddress;
    }

    public Section getSectionAddress() {return sectionAddress;}

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

    public Phrase getMainPageSearchValue() {return mainPageSearchValue;}

    public Http getTwitterAddress() {return twitterAddress;}
}

