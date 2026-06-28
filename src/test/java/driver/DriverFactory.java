package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.Locale;

public class DriverFactory {
    private DriverFactory() {}
    public static WebDriver createDriver(String browser, boolean headless) {
        WebDriver driver;
        switch (browser.toLowerCase(Locale.ROOT)){
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();

                if(headless){
                    options.addArguments("--headless=new");
                }

                driver = new EdgeDriver(options);
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if(headless){
                    options.addArguments("--headless=new");
                }

                driver = new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}
