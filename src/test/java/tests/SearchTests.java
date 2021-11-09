package tests;

import lib.CoreTestCase;
import lib.Ui.SearchPageObject;
import org.testng.annotations.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        SearchPageObject.initSearchInput("Hunter Thompson");
        SearchPageObject.initSearchInitInput();
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        SearchPageObject.initSearchInput("regwrg");
        SearchPageObject.initForElementClear();
        SearchPageObject.initSearchInput("Jack London");
        SearchPageObject.initForElementClear();
        SearchPageObject.initSearchBack();
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        String search_line = "Cannibal Corpse discography";
        SearchPageObject.initSearchInput(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticle();
        assertTrue(
                "We found too few result",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchSkip();
        SearchPageObject.initSearchInit();
        String search_line = "Csdverbebrberberb";
        SearchPageObject.initSearchInput(search_line);
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
