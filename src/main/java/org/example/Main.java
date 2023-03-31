package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        1/ login
//        loginForm("test", "test");
//        2/ handle checkboxes
//        handleCheckboxes();
        //3/ handle dropdown list
        System.out.println("hello world aaaaa");
        handleDropdownList();

    }
    public static void loginForm(String user, String pass) throws InterruptedException {
        String username = user;
        String password = pass;

        WebDriver driver = InitBrowser.InitChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        driver.quit();
    }

    public static void handleCheckboxes() throws InterruptedException{
        WebDriver driver = InitBrowser.InitChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> listItem = driver.findElements(By.cssSelector("input[type='checkbox']"));
//        listItem.get(0).click();
//        listItem.get(1).click();
        for (WebElement checkItem : listItem) {
            if (!checkItem.isSelected()){
                checkItem.click();
            }
        }
        Thread.sleep(1000);
        driver.quit();
    }

    public static void handleDropdownList() throws InterruptedException {
        WebDriver driver = InitBrowser.InitChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement listItems = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(listItems);
        select.selectByVisibleText("Option 1");
        Thread.sleep(1000);
        driver.quit();
    }
}