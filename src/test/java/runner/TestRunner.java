package runner;

import desktop.pages.AccountPage;
import desktop.pages.HomePage;
import desktop.pages.SearchResultsPage;
import driver.SingletonDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    HomePage homePageObject;
    AccountPage accPageObject;
    SearchResultsPage searchResultsPageObject;
    WebDriver driver = SingletonDriver.getInstance();

    @AfterAll
    public static void tearDown() {
        SingletonDriver.getInstance().quit();
    }

    @Test
    public void homePageSearch() {
        homePageObject = new HomePage(driver);
        homePageObject.enterSearchTerm("Thinking");
        searchResultsPageObject = homePageObject.searchButtonClick();
        Assertions.assertTrue(searchResultsPageObject.isSearchResultsPresent());
    }

    @Test
    public void loginToAccount() {
        homePageObject = new HomePage(driver);
        accPageObject = homePageObject.navBarClick();
        accPageObject.isLoginTitleDisplayed();
        accPageObject.fillInSignInFields("test@valid.com", "qwerty");
        accPageObject.checkURL();
    }
}

