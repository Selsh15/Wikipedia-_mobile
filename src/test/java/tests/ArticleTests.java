package tests;

import lib.CoreTestCase;
import lib.Ui.ArticlePageObject;
import lib.Ui.SearchPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleTests extends CoreTestCase
{
    @Test
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        SearchPageObject.initSearchInput("Hunter Thompson");
        SearchPageObject.initSearchInitInput();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.intSearchSwipe();
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                article_title,
                "Hunter S. Thompson",
                "We see unexpeted title"
        );
    }
    @Test
    public void testSwipeArticle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        SearchPageObject.initSearchInput("Hunter Thompson");
        SearchPageObject.initSearchInitInput();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.intSearchSwipeElement();
    }
}
