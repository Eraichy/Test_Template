package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Environment.getEnvironment;
import static helpers.Locators.getLocator;

public class AddFolderSubwindow {
    private final static String FOLDER_NAME = getEnvironment("Global.newFolderName");

    private final static By FOLDER_NAME_FIELD = getLocator("AddFolderSubwindow.nameField");
    private final static By SUBMIT_BUTTON = getLocator("AddFolderSubwindow.submitButton");

    public static void createFolder() {
        $(FOLDER_NAME_FIELD).sendKeys(FOLDER_NAME);
        $(SUBMIT_BUTTON).click();
    }
}
