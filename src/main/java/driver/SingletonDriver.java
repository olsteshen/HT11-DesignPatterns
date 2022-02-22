package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {
        WebDriverManager.chromedriver().setup();
        driver.manage().deleteAllCookies();
    };

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
