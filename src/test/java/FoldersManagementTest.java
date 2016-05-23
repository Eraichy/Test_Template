import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.AssertJUnit.assertTrue;
import static pages.FoldersSettingsPage.closeConfirmWindow;
import static pages.FoldersSettingsPage.isFolderDeleted;

public class FoldersManagementTest extends TestBase {

    @Override
    @BeforeClass
    public void login() {
        LoginPage.shouldAppear();
        LoginPage.login();
        MailPage.shouldAppear();
        Header.openSettingsPage();
        SettingsPage.shouldAppear();
        SettingsPage.openFolderSettings();
        FoldersSettingsPage.shouldAppear();
    }

    @Test
    public void addNewFolderTest() {
        FoldersSettingsPage.addFolderButtonClick();
        AddFolderSubwindow.createFolder();
        boolean isFolderCreated = FoldersSettingsPage.checkNewFolder();
        try {
            FoldersSettingsPage.deleteNewFolder();
        }
        catch (Exception e) {}
        assertTrue("New folder not added.", isFolderCreated);
    }

    @Test
    public void deleteNewFolderTest() {
        FoldersSettingsPage.addFolderButtonClick();
        AddFolderSubwindow.createFolder();
        FoldersSettingsPage.deleteNewFolder();
        assertTrue(isFolderDeleted());
    }
}
