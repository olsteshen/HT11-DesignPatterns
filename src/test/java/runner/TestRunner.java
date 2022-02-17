package runner;

import desktop.pages.AccountPage;
import desktop.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
@SelectPackages("put your packages here")

public class TestRunner extends DriverManager {
    HomePage homePageObject;
    AccountPage accPageObject;

    @Test
    public void homePageSearch() {
        driver.get("https://www.bookdepository.com");
        homePageObject = new HomePage(driver);
        homePageObject.enterSearchTerm();
        homePageObject.searchButtonClick();
        Assert.assertTrue(homePageObject.checkSearchResultsPresent());
    }

    @Test
    public void signInToAccount() {
        driver.get("https://www.bookdepository.com");
        homePageObject = new HomePage(driver);
        homePageObject.navBarClick();
        accPageObject = new AccountPage(driver);
        accPageObject.checkLoginTitleDisplayed();
        accPageObject.loginToAccount("test@valid.com", "qwerty");
        Assert.assertTrue(accPageObject.checkURL());
    }
}

