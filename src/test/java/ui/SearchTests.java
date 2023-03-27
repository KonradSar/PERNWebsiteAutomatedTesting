package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.HeaderSection;
import page.objects.HeaderTab;
import page.objects.SearchResultsPage;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SearchTests extends BaseTest {
    HeaderSection headerSection;
    SearchResultsPage searchResultsPage;

    @BeforeEach
    public void initializeObjects() {
        headerSection = new HeaderSection(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void When_SearchPhraseIsAddedToSearchField_Expect_ResultsNumberIsNotZero() {
        // Given
        headerSection.openTabElement(HeaderTab.SEARCH_BTN);

        // When
        headerSection.searchInSomeText(testDataReader.getMainPageSearchExpression().getRightSearchValue());

        // Then
        assertTrue(searchResultsPage.isAnyResultNumber());
    }

    @Test
    public void When_SearchWrongPhraseIsAddedToSearchField_Expect_ResultsNumberIsZero() {
        // Given
        headerSection.openTabElement(HeaderTab.SEARCH_BTN);

        // When
        headerSection.searchInSomeText(testDataReader.getMainPageSearchValue().getWrongSearchValue());

        // Then
        assertFalse(searchResultsPage.isAnyResultNumber());
    }
}
