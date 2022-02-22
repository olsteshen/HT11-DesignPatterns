package runner;

import desktop.pages.AccountPage;
import desktop.pages.HomePage;
import driver.SingletonDriver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;


public class TestRunner{
    HomePage homePageObject;
    AccountPage accPageObject;
    WebDriver driver = SingletonDriver.getInstance();

    @Test
    public void homePageSearch() {
        homePageObject = new HomePage(driver);
        homePageObject.enterSearchTerm();
        homePageObject.searchButtonClick();
        Assert.assertTrue("No Search results present", homePageObject.checkSearchResultsPresent());
    }

    @Test
    public void loginToAccount() {
        homePageObject = new HomePage(driver);
        accPageObject = homePageObject.navBarClick();
        accPageObject.checkLoginTitleDisplayed();
        accPageObject.fillInSignInFields("test@valid.com", "qwerty");
        Assert.assertTrue("Incorrect URL for Sign In page", accPageObject.checkURL());
    }

    @AfterEach
    public void tearDown() {
        SingletonDriver.getInstance().quit();
    }
}

