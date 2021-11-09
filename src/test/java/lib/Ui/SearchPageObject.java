package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends  MainPageObject{

    private static final String
        SEARCH_SKIP_ELEMENT = "id:org.wikipedia:id/fragment_onboarding_skip_button",
        SEARCH_INIT_ELEMENT =  "xpath://*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INIT_INPUT_ELEMENT =  "xpath://*[contains(@text, 'Hunter S. Thompson')]",
        SEARCH_CLEAR_ELEMENT = "id:org.wikipedia:id/search_src_text",
        SEARCH_INIT_BACK = "xpath://*[@class='android.widget.ImageButton']",
        SEARCH_RESULT_TPL = "xpath://*[contains(@text, '{SUBSTRING}')]",
        SEARCH_RESULT_ELEMENT = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]",
        SEARCH_RESULT_LOCATOR_LABEL = "xpath://*[@text='No results']",
        SEARCH_RESULT_LOCATOR = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]",
        SEARCH_CLICK_ELEMENT_JAVA = "xpath://*[contains(@text, 'Object-oriented programming language')]",
        SEARCH_GET_ATTRIBUTE = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]",
        SEARCH_ELEMENT_PRESENT = "xpath://*[contains(@text, 'Object-oriented programming language')]";
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    private static String getResultSearchElement(String substring)
    {
        return  SEARCH_RESULT_TPL.replace("{SUBSTRING}", substring);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_id = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_id,"Not Result "+ substring, 15);
    }
    public void initSearchSkip()
    {
        this.waitForElementAndClick(SEARCH_SKIP_ELEMENT, "Cannot find and click search skip element",15);
        this.waitForElementPresent(SEARCH_SKIP_ELEMENT, "Cannot find and click search skip element.",15);
    }
    public void initSearchInit()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element",15);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find and click search init element",15);
    }
    public void initSearchInput(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and click search input element",15);
    }
    public void initSearchInitInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_INPUT_ELEMENT, "Cannot find and click search init element",15);
        this.waitForElementPresent(SEARCH_INIT_INPUT_ELEMENT, "Cannot find and click search init element",15);
    }
    public void initForElementClear()
    {
        this.waitForElementAndClear(SEARCH_CLEAR_ELEMENT, "Not text", 10);
        this.waitForElementPresent(SEARCH_CLEAR_ELEMENT, "Cannot find and click search init element",15);
    }
    public void initSearchBack()
    {
        this.waitForElementAndClick(SEARCH_INIT_BACK, "Not click back vutton", 10);
    }
    public int getAmountOfFoundArticle()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
    public void waitForEmptyResultLable()
    {
        this.waitForElementPresent(SEARCH_RESULT_LOCATOR_LABEL,"By element for list", 15);
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_LOCATOR,"We've found some results by request");
    }
    public void initSearchClickResult()
    {
        this.waitForElementAndClick(SEARCH_CLICK_ELEMENT_JAVA,"Cannot find search input", 15);
    }
    public String initForElementAndGetAttribute()
    {
        this.waitForElementAndGetAttribute(SEARCH_GET_ATTRIBUTE,"text", "Cannot find title of article", 15);
        return null;
    }
    public void initForElementPresent()
    {
        this.waitForElementPresent(SEARCH_ELEMENT_PRESENT,"Cannot find article after returning from background", 15);
    }
}

