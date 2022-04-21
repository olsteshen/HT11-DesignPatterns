package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SingletonDriver {
    private static WebDriver driver;

    private SingletonDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriverManager.chromedriver().driverVersion("100.0.4896.88 ").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            new SingletonDriver();
        }
        return driver;
    }
}
