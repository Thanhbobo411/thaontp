package test;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleJSAlerts {
    public static void main(String[] args) {
        //1. Init webdriver session
        WebDriver driver = DriverFactory.getEdgeDriver();
        //2. open target page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //3. find a list of checkboxes Element
        WebElement jsAlertItem = driver.findElement(By.cssSelector("[onclick='jsAlert()']"));
        WebElement jsConfirmItem = driver.findElement(By.cssSelector("[onclick='jsConfirm()']"));
        WebElement jsPromptItem = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        WebElement resultContent = driver.findElement(By.id("result"));

        //handle JS Alert
        jsAlertItem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content: " + alert.getText());
        alert.accept();
        System.out.println("Result: "+ resultContent.getText());
        System.out.println("-----");

        //handle JS confirm alert
        jsConfirmItem.click();
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content: " + confirmAlert.getText());
        confirmAlert.accept();
        System.out.println("Result: " + resultContent.getText());
        System.out.println("-----");

        //handle JS prompt alert
        jsPromptItem.click();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content: "+ promptAlert.getText());
        promptAlert.sendKeys("Hello world!!!");
        promptAlert.accept();
        System.out.println("result: " + resultContent.getText());

        //debug purpose only
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
        //7. quit browser session
        driver.quit();
    }
}
