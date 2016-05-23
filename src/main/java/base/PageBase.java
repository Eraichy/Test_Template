package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class PageBase {
    protected static void shouldAppear(String pageTitle){
        waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 15);
        wait.until(titleContains(pageTitle));
    }

    public static void waitForPageToLoad() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                boolean complete = ((String) js.executeScript("return document.readyState")).equalsIgnoreCase("complete");
                if (!complete) {
                    sleep(1000);
                }
                return complete;
            }
        });
    }
}
