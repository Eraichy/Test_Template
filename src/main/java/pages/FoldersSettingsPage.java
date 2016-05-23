package pages;


import base.PageBase;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Environment.getEnvironment;
import static helpers.Locators.getLocator;
import static helpers.PageText.getPageText;

public class FoldersSettingsPage extends PageBase {
    private static final String TITLE = getPageText("FoldersSettingPage.title");

    private static final By ADD_FOLDER_BUTTON = getLocator("FoldersSettingPage.addFolderButton");
    private static final By FOLDERS_LIST = getLocator("FoldersSettingPage.listFolders");
    private static final By DELETE_FOLDER_BUTTON = getLocator("FoldersSettingPage.removeNewFolderButton");
    private static final By CONFIRM_DELETE_BUTTON = getLocator("FoldersSettingPage.confirmDeleteButton");
    private static final By CLOSE_CONFIRM_BUTTON = getLocator("FoldersSettingPage.closeConfirmWindowButton");

    private static final String NEW_FOLDER_NAME = getEnvironment("Global.newFolderName");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void addFolderButtonClick() {
        $(ADD_FOLDER_BUTTON).click();
    }

    public static void deleteNewFolder() throws StaleElementReferenceException {
        List<SelenideElement> folders = $$(FOLDERS_LIST);

        for (WebElement folder: folders) {
            if(folder.getText().contains(NEW_FOLDER_NAME)) {
                Actions actions = new Actions(WebDriverRunner.getWebDriver());
                actions.moveToElement(folder).build().perform();
                $(DELETE_FOLDER_BUTTON).click();
                $(CONFIRM_DELETE_BUTTON).click();
            }
        }

    }

    public static boolean checkNewFolder() {
        List<SelenideElement> folders = $$(FOLDERS_LIST);
        for (SelenideElement folder: folders) {
            if(folder.getText().contains(NEW_FOLDER_NAME)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFolderDeleted() {
        List<SelenideElement> folders = $$(FOLDERS_LIST);
        for (SelenideElement folder: folders) {
            if(folder.getText().contains(NEW_FOLDER_NAME)) {
                return false;
            }
        }
        return true;
    }

    public static void closeConfirmWindow() {
        $(CLOSE_CONFIRM_BUTTON).click();
    }
}
