package test;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HandleRightClick {
    public static void main(String[] args) throws InterruptedException {
        //Init browser
        WebDriver driver  = DriverFactory.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //target the page
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //get elements
        WebElement rightClickPlace = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(rightClickPlace).perform();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        driver.navigate().refresh();


        //debug only
        Thread.sleep(2000);
        driver.quit();
    }
}
