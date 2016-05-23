package pages;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;
import static helpers.PageText.getPageText;

public class SettingsPage extends PageBase {
    private static final String TITLE = getPageText("SettingPage.title");

    private static final By FOLDERS_LINK = getLocator("SettingPage.foldersLink");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void openFolderSettings() {
        $(FOLDERS_LINK).click();
    }
}
