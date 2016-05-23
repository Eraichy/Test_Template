package pages;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;

public class Header extends PageBase {
    private static final By LOGOUT_BUTTON = getLocator("Header.logoutButton");
    private static final By CONTACTS_BUTTON = getLocator("Header.contactsButton");
    private static final By PERSONAL_MENU_BUTTON = getLocator("Header.personalMenuButton");
    private static final By SETTINGS_BUTTON = getLocator("Header.settingsButton");

    public static void logout() {
        $(LOGOUT_BUTTON).click();
    }

    public static void goToContacts() {
        $(CONTACTS_BUTTON).click();
    }

    public static void openSettingsPage() {
        $(PERSONAL_MENU_BUTTON).click();
        $(SETTINGS_BUTTON).click();
    }
}
