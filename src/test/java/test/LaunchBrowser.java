package test;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getEdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        driver.quit();
    }
}
