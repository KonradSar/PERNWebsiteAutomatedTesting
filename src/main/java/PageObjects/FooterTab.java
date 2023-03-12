package PageObjects;

import org.openqa.selenium.By;

public enum FooterTab {

    YOUTUBE_LOGO(By.xpath(".//a[@href = 'https://www.youtube.com/channel/UCJnkxHoJhVynx-jXjv6OaRg']")),

    LINKEDIN_LOGO(By.xpath(".//a[@href = 'https://www.linkedin.com/company/pern-s-a/']"));
    final By tabLocator;

    FooterTab(By locator) {
        tabLocator = locator;
    }
}
