package POMTests;

import PageObjects.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class LanguageVersionTests extends BaseTest {
    MainPage mainPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void When_LanguageIsSwitchedFromPLToEN_Expect_ENLanguageIsOn() {
        // When
        mainPage.changeLanguageToEN();

        // Then
        assertTrue(driver.getPageSource().contains("lang=\"en-US\""));
        mainPage.getServicesLinkTextENLanguagePageVersion().equals("Services");
    }

    @Test
    public void When_LanguageIsSwitchedFromPLToDE_Expect_DELanguageIsOn() {
        // When
        mainPage.changeLanguageToDE();

        // Then
        assertTrue(driver.getPageSource().contains("lang=\"de-DE\""));
        mainPage.getServicesLinkTextDELanguagePageVersion().equals("Dienstleistungen");
    }
}
