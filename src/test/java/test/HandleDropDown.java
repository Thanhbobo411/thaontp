package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {
    public static void main(String[] args) {
        //1. Init browser
        WebDriver driver = DriverFactory.getChromeDriver();
        //2. Open target page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ListOptions = driver.findElement(By.id("dropdown"));
        Select select = new Select(ListOptions);

        select.selectByVisibleText("Option 1");

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }

        //Quit session
        driver.quit();
    }
}
