package page.objects;

import org.openqa.selenium.By;

public enum HeaderTab {
    SEARCH_BTN(By.xpath(".//li[@class = 'menu-item menu-item--search']/div"));
    final By tabLocator;
    HeaderTab(By locator) {
        tabLocator = locator;
    }
}

