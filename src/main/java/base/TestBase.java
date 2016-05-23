package base;

import com.codeborne.selenide.Configuration;
import helpers.Screenshooter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.Header;
import pages.LoginPage;
import pages.MailPage;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Environment.getEnvironment;

@Listeners(Screenshooter.class)
public class TestBase {
    protected static final String BASE_URL = getEnvironment("Global.baseUrl");

    @BeforeTest
    public void setUp() {
        Configuration.baseUrl = System.getProperty("url", BASE_URL);
        Configuration.timeout = 15000;
        open(Configuration.baseUrl);
    }

    @BeforeClass
    public void login() {
        LoginPage.shouldAppear();
        LoginPage.login();
        MailPage.shouldAppear();
    }

    @AfterClass
    public void logout() {
        Header.logout();
        LoginPage.shouldAppear();
    }
}