package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HandleCheckboxes {
    public static void main(String[] args) {
        //1. Init webdriver session
        WebDriver driver = DriverFactory.getEdgeDriver();

        //2. open target page
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. find a list of checkboxes Element
        List<WebElement> listCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox'"));
        WebElement checkboxElem01 = listCheckboxes.get(0);
        WebElement checkboxElem02 = listCheckboxes.get(1);

        //4. Select option
        checkboxElem01.click();
        checkboxElem02.click();

        // select all
        for (WebElement listCheckbox : listCheckboxes) {
            if (!listCheckbox.isSelected()) {
                listCheckbox.click();
            }
        }
        System.out.printf("", listCheckboxes);


        //debug purpose only
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
        //7. quit browser session
        driver.quit();
    }
}
