package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Driver;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver getEdgeDriver() {
//        String currentProjectLocation = System.getProperty("user.dir");
//        String chromeDriverRelativePath = "/src/test/resources/drivers/chromedriver.exe";
//        String edgeDriverPath = currentProjectLocation.concat(chromeDriverRelativePath);
//        System.setProperty("webdriver.chrome.driver", edgeDriverPath);

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static WebDriver getChromeDriver() {
        //handle 403 error
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver();

        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
