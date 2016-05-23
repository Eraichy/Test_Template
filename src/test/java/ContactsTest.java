import base.TestBase;
import org.testng.annotations.BeforeClass;
import pages.Header;

public class ContactsTest extends TestBase {

    @Override
    @BeforeClass
    public void login() {
        super.login();
        Header.goToContacts();
    }
}
