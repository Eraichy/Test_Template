import base.TestBase;
import org.testng.annotations.Test;
import pages.MailPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

import static helpers.PageText.getPageText;

@Features("Mail Page Tests")
public class MailPageTest extends TestBase {
    private static final String INBOX_TITLE = getPageText("MailPage.inboxPageTitle");
    private static final String SENT_ITEMS_TITLE = getPageText("MailPage.sentItemsPageTitle");
    private static final String DRAFTS_TITLE = getPageText("MailPage.draftsPageTitle");
    private static final String SPAM_TITLE = getPageText("MailPage.spamPageTitle");
    private static final String TRASH_TITLE = getPageText("MailPage.trashPageTitle");

    @Title("Basic UI elements Test")
    @Description("Verify all ui elements")
    @Test
    public void basicUiElementsTest() {
        MailPage.checkAllUiElements();
    }

    @Test
    public void openInboxTest() {
        MailPage.openInbox();
        MailPage.checkChildPageTitle(INBOX_TITLE);
    }

    @Test
    public void openSentItemsTest() {
        MailPage.openSentItems();
        MailPage.checkChildPageTitle(SENT_ITEMS_TITLE);
    }

    @Test
    public void openDraftsTest() {
        MailPage.openDrafts();
        MailPage.checkChildPageTitle(DRAFTS_TITLE);
    }

    @Test
    public void openSpamTest() {
        MailPage.openSpam();
        MailPage.checkChildPageTitle(SPAM_TITLE);
    }

    @Test
    public void openTrashTest() {
        MailPage.openTrash();
        MailPage.checkChildPageTitle(TRASH_TITLE);
    }
}
