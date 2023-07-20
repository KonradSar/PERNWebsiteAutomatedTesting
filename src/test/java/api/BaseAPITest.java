package api;

import org.junit.jupiter.api.BeforeAll;
import utils.Http;
import utils.Phrase;
import utils.Section;
import utils.TestDataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BaseAPITest {
    protected static TestDataReader testDataReader;
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";

    @BeforeAll
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(TEST_DATA_LOCATION), StandardCharsets.UTF_8));
        testDataReader = new TestDataReader(TEST_DATA_LOCATION, new Section(properties),
                new Http(properties), new Http(properties), new Http(properties), new Phrase(properties), new Http(properties));
    }
}
