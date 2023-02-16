package POMTests;

import Utils.Section;
import Utils.TestDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected static String baseURL;

    protected static TestDataReader testDataReader;
    private static String testDataLocation = "src/configs/Configuration.properties";


    @BeforeAll
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("src/configs/Configuration.properties"), StandardCharsets.UTF_8));
        baseURL = properties.getProperty("baseURL");
        testDataReader = new TestDataReader(testDataLocation, new Section(properties));

    }

    @BeforeEach
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
