package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.objects.CookiesSection;
import page.objects.FooterSection;
import page.objects.FooterTab;
import page.objects.PrivacyPolicySection;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FooterTests extends BaseTest {
    FooterSection footerSection;
    CookiesSection cookiesSection;
    PrivacyPolicySection privacyPolicySection;

    @BeforeEach
    public void initializeObjects() {
        footerSection = new FooterSection(driver);
        cookiesSection = new CookiesSection(driver);
        privacyPolicySection = new PrivacyPolicySection(driver);
    }

    @Test
    public void When_YouTubeFooterSectionIsClicked_Expect_YouTubePagePERNMaterialsIsDisplayed() {
        // When
        footerSection.openTabElement(FooterTab.YOUTUBE_LOGO);
        cookiesSection.closeYouTubeCookiesBtn();

        // Then
        assertEquals(testDataReader.getYouTubeAddress().getYouTubeURL(), driver.getCurrentUrl());
    }

    @Test
    public void When_LinkedInFooterSectionIsClicked_Expect_LinkedInPageMaterialsIsDisplayed() {
        // When
        footerSection.openTabElement(FooterTab.LINKEDIN_LOGO);
        cookiesSection.closeLinkedInCookiesBtn();
        privacyPolicySection.closeLinkedINPrivacyPolicyView();

        // Then
        assertTrue(driver.getCurrentUrl().contains(testDataReader.getLinkedInAddress().getLinkedInURL()));
    }
}
