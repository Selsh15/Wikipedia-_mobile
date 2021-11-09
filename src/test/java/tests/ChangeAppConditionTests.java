package tests;

import lib.CoreTestCase;
import lib.Ui.ArticlePageObject;
import lib.Ui.SearchPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeAppConditionTests extends CoreTestCase
{
    @Test // Сравнение заголовков до и после поворота экрана
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        String search_line = "Java";
        SearchPageObject.initSearchInput(search_line);
        SearchPageObject.initSearchClickResult();
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.intSearchSwipeJava();
        String title_before_rotation = SearchPageObject.initForElementAndGetAttribute();
        this.rotateScreenLendScape();
        ArticlePageObject.intSearchSwipeJava();
        String title_after_rotation = SearchPageObject.initForElementAndGetAttribute();
        Assert.assertEquals(
                title_after_rotation,
                title_before_rotation,
                "Article title have been changed after screen rotation ferst");
        this.rotateScreenPortrait();
        String title_after_aftor_second_rotation = SearchPageObject.initForElementAndGetAttribute();
        Assert.assertEquals(
                title_before_rotation,
                title_after_aftor_second_rotation,
                "Article title have been changed after screen rotation second"
        );

    }

    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        String search_line = "Java";
        SearchPageObject.initSearchInput(search_line);
        SearchPageObject.initForElementPresent();
        this.InBackground();
        SearchPageObject.initForElementPresent();
    }
}
