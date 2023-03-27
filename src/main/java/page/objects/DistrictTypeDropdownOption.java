package page.objects;

import org.openqa.selenium.By;

public enum DistrictTypeDropdownOption {
    SILESIA_DISTRICT(By.cssSelector("#regions option:nth-child(13)"));
    final By districtTypeLocator;
    DistrictTypeDropdownOption(By locator) {
        districtTypeLocator = locator;
    }
}
