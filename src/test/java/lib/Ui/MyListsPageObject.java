package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{
    private static final String
    SWIPE_ELEMENT_LEFT = "id:org.wikipedia:id/page_list_item_title",
    CHECK_TEXT_DELITE = "xpath://*[contains(@text, 'You have no articles added to this list')]";
    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void initSearchSwipeLeft()
    {
        this.swipeElementToLeft(SWIPE_ELEMENT_LEFT, "Can't swipe left", 15);
        this.waitForElementPresent(CHECK_TEXT_DELITE,"Not text",15);
    }




}
