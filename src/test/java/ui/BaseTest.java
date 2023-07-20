package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Http;
import utils.Phrase;
import utils.Section;
import utils.TestDataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected static String baseURL;
    protected static TestDataReader testDataReader;
    private final static String TEST_DATA_LOCATION = "src/configs/Configuration.properties";

    @BeforeAll
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(TEST_DATA_LOCATION), StandardCharsets.UTF_8));
        baseURL = properties.getProperty("baseURL");
        testDataReader = new TestDataReader(TEST_DATA_LOCATION, new Section(properties), new Http(properties),
                new Http(properties), new Http(properties),new Phrase(properties), new Http(properties));
    }

    @BeforeEach
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
