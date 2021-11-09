package tests;

import lib.CoreTestCase;
import lib.Ui.ArticlePageObject;
import lib.Ui.MyListsPageObject;
import lib.Ui.NavigationUI;
import lib.Ui.SearchPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testTabInvest()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        SearchPageObject.initSearchInput("Hunter Thompson");
        SearchPageObject.initSearchInitInput();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                article_title,
                "Hunter S. Thompson",
                "We see unexpeted title"
        );
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.initSearchAddBookmark();
        NavigationUI.initSearchClickBack();
        SearchPageObject.initSearchBack();
        NavigationUI.initSearchClickSaved();
        NavigationUI.initSearchClickListItem();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.initSearchSwipeLeft();

    }
}
