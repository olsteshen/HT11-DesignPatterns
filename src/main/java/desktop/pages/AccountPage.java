package desktop.pages;

import abstractclasses.page.AbstractPage;
import desktop.fragments.NavigationBarFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='ap_email']")
    WebElement emailField;

    @FindBy(xpath = "//div[contains(@class,'a-input-text-group')]//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//form[@name='signIn']//input[@id='signInSubmit']")
    WebElement submitButton;

    @FindBy(xpath = "//h1[contains(@class,'a-spacing-top-small')]")
    public WebElement titleText;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    NavigationBarFragment navigationBar = new NavigationBarFragment(driver);

    private static String accountPageUrl = "https://www.bookdepository.com/account/login/to/account";
    private static String successfulLoginPageURL = "https://www.bookdepository.com/ap/signin";


    public void openPage() {
        getDriver().get(accountPageUrl);
    }

    public boolean checkURL() {
        String currentURL = driver.getCurrentUrl();
        return (currentURL == successfulLoginPageURL);
    }

    public void enterEmail(String strEmail) {
        emailField.clear();
        emailField.sendKeys(strEmail);
    }

    public void enterPassword(String strPassword) {
        passwordField.sendKeys(strPassword);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public Boolean checkLoginTitleDisplayed() {
        return titleText.isDisplayed();
    }

    public String getLoginPageTitle() {
        return titleText.getText();
    }

    public void navBarClick() {
        navigationBar.signInCTAClick();
    }

    public void loginToAccount(String strEmail, String strPassword) {
        this.enterEmail(strEmail);
        this.enterPassword(strPassword);
        this.clickSubmitButton();
    }
}
