package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class NavigationUI extends MainPageObject {
    private static final String
            MENU_BOOKMARK = "id:org.wikipedia:id/article_menu_bookmark",
            CLICK_BACK = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            CLICK_SAVED = "xpath://*[contains(@text, 'Saved')]",
            CLICK_LIST_ITEM_TITLE = "id:org.wikipedia:id/item_title";
             public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchAddBookmark() {
        this.waitForElementAndClick(MENU_BOOKMARK, "Can't click button bookmark", 20);
    }

    public void initSearchClickBack() {
        this.waitForElementAndClick(CLICK_BACK, "Not CLICK_BACK", 15);
    }

    public void initSearchClickSaved() {
        this.waitForElementAndClick(CLICK_SAVED, "Not click button saved", 15);
    }
    public void initSearchClickListItem()
    {
        this.waitForElementAndClick(CLICK_LIST_ITEM_TITLE,"Not Item list", 15);
    }

}
