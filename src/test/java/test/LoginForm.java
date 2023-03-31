package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginForm {
    public static void main(String[] args) {
        //1 Init webdriver session
        WebDriver driver = DriverFactory.getEdgeDriver();
        //2 Open login page
        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/login");
            //3 Find username web element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
//            WebElement usernameEle = driver.findElement(By.id("username_"));
            //4 Find password web element
            WebElement passwordEle = driver.findElement(By.id("password"));
            //5 Find login btn web element
            WebElement loginBtnEle = driver.findElement(By.cssSelector("button[type='submit']"));
            //6 Input username, password, click on login btn
            usernameEle.sendKeys("admin");
            passwordEle.sendKeys("admin");
            loginBtnEle.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //7 Quit browser session
        driver.quit();
    }
}
