package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "xpath://*[@text='Hunter S. Thompson']",
            SEARCH_SWIPE_ELEMENT = "xpath://*[@text='Hunter S. Thompson']",
            SEARCH_SWIPE_ELEMENT_FIND = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[6]/android.view.View[1]",
            SEARCH_SWIPE_ELEMENT_JAVA = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]";
    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    private WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Not title", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }
    public void intSearchSwipe() {
        this.swipeUpToFindElement(SEARCH_SWIPE_ELEMENT, "Not swipe for element ", 30);
    }
    public void intSearchSwipeElement()
    {
        this.swipeUpToFindElement(SEARCH_SWIPE_ELEMENT_FIND,"Not swipe for element", 30);
    }
    public void intSearchSwipeJava()
    {
        this.swipeUpToFindElement(SEARCH_SWIPE_ELEMENT_JAVA,"Not java element", 1);
    }
}


