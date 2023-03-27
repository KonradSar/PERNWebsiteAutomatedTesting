package page.objects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
