package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Environment.getEnvironment;
import static helpers.Locators.getLocator;
import static helpers.PageText.getPageText;

public class LoginPage extends PageBase{
    private static final String LOGIN = getEnvironment("Global.login");
    private static final String PASSWORD = getEnvironment("Global.password");
    private static final String TITLE = getPageText("LoginPage.title");

    private static final By LOGIN_FIELD = getLocator("LoginPage.loginField");
    private static final By PASSWORD_FIELD = getLocator("LoginPage.passwordField");
    private static final By BK_RU_OPTION = getLocator("LoginPage.bkRuOption");
    private static final By LOGIN_BUTTON = getLocator("LoginPage.loginButton");
    private static final By DOMAIN_SELECTOR = getLocator("LoginPage.domainSelector");


    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void login() {
        $(LOGIN_FIELD).clear();
        $(LOGIN_FIELD).sendKeys(LOGIN);
        $(PASSWORD_FIELD).sendKeys(PASSWORD);
        Select select = new Select($(DOMAIN_SELECTOR));
        select.selectByValue("bk.ru");
        $(LOGIN_BUTTON).click();
    }
}
