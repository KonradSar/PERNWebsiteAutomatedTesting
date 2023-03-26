package POMTests;

import PageObjects.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class DropDownMenuTests extends BaseTest {
    MainPage mainPage;

    @BeforeEach
    public void initializeObjects() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void When_MainPageIsLoaded_Expect_RegionsDropDownMenuContains17Elements() {
        assertTrue(mainPage.isRegionsRangeInDropDownCorrect());
    }

    @Test
    public void When_MainPageIsLoaded_Expect_LocationsTypeDropDownMenuContains6Elements() {
        assertTrue(mainPage.isTypeOfLocationRangeCorrect());
    }
}
