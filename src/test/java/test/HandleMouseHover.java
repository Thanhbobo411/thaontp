package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HandleMouseHover {
    public static void main(String[] args) throws InterruptedException {
        //Init browser and target the page
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        //handle mouse hovers
        //find list elements
        List <WebElement> avaSelector = driver.findElements(By.cssSelector(".figure"));
        List <WebElement> userSelector = driver.findElements(By.cssSelector(".figcaption h5"));
        List <WebElement> profileSelector = driver.findElements(By.cssSelector(".figcaption a"));

        //move mouse on 1st user
        Actions actions = new Actions(driver);
        actions.moveToElement(avaSelector.get(0)).perform();
        System.out.println(userSelector.get(0).getText());
        System.out.println(profileSelector.get(0).getAttribute("href"));
        Thread.sleep(2000);

        //move mouse on 2nd user
        actions.moveToElement(avaSelector.get(1)).perform();
        System.out.println(userSelector.get(1).getText());
        System.out.println(profileSelector.get(1).getAttribute("href"));
        Thread.sleep(2000);

        //move mouse on 3rd user
        actions.moveToElement(avaSelector.get(2)).perform();
        System.out.println(userSelector.get(2).getText());
        System.out.println(profileSelector.get(2).getAttribute("href"));

        //debug only
        Thread.sleep(2000);
        //Quit session browser
        driver.quit();
    }
}
