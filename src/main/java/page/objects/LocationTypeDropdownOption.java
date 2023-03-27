package page.objects;

import org.openqa.selenium.By;

public enum LocationTypeDropdownOption {
    FUEL_BASES(By.cssSelector("#locations option:nth-child(5)")),
    OIL_BASES(By.cssSelector("#locations option:nth-child(4)"));
    final By typeOfLocationLocator;

    LocationTypeDropdownOption(By locator) {
        typeOfLocationLocator = locator;
    }
}
