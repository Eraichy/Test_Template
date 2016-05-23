package pages;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.getLocator;
import static helpers.PageText.getPageText;

public class MailPage extends PageBase {
    private static final String TITLE = getPageText("MailPage.title");

    private static final By COMPOSE_BUTTON = getLocator("MailPage.composeButton");
    private static final By INBOX_LINK = getLocator("MailPage.inboxLink");
    private static final By SENT_ITEMS_LINK = getLocator("MailPage.sentItemsLink");
    private static final By DRAFTS_LINK = getLocator("MailPage.draftsLink");
    private static final By SPAM_LINK = getLocator("MailPage.spamLink");
    private static final By TRASH_LINK = getLocator("MailPage.trashLink");
    private static final By MAIL_BLOCK_LINKS = getLocator("MailPage.mailBlockLinks");
    private static final By[] MAIL_BLOCK = new By[] {
            COMPOSE_BUTTON,
            INBOX_LINK,
            SENT_ITEMS_LINK,
            DRAFTS_LINK,
            SPAM_LINK,
            TRASH_LINK
    };

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkChildPageTitle(String title) {
        PageBase.shouldAppear(title);
    }

    public static void checkAllUiElements() {
        for(By locator : MAIL_BLOCK) {
            $(locator).should(exist);
        }
    }

    public static void openInbox() {
        $(INBOX_LINK).click();
    }

    public static void openSentItems() {
        $(SENT_ITEMS_LINK).click();
    }

    public static void openDrafts() {
        $(DRAFTS_LINK).click();
    }

    public static void openSpam() {
        $(SPAM_LINK).click();
    }

    public static void openTrash() {
        $(TRASH_LINK).click();
    }

}
