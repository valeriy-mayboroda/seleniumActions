import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandlerImpl implements WebDriverEventListener {

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Try to open the " + s + " URL");
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("The " + s + " URL is successfully opened");
    }

    public void beforeNavigateBack(WebDriver webDriver) {}

    public void afterNavigateBack(WebDriver webDriver) {}

    public void beforeNavigateForward(WebDriver webDriver) {}

    public void afterNavigateForward(WebDriver webDriver) {}

    public void beforeNavigateRefresh(WebDriver webDriver) {}

    public void afterNavigateRefresh(WebDriver webDriver) {}

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Try to find WebElement");
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("WebElement is successfully found");
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Try to click WebElement");
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("The " + webElement + " WebElement is successfully clicked");
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {}

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {}

    public void beforeScript(String s, WebDriver webDriver) {}

    public void afterScript(String s, WebDriver webDriver) {}

    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println(throwable.getStackTrace());
    }
}
