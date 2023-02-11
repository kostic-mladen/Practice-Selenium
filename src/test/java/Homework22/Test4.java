package Homework22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Test4 {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("suitor22");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Bootcamp22@");
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,450)", "");
        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        WebElement book1 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        List<WebElement> profile = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile.size(); i++) {
            if (profile.get(i).getText().equals("Add To Your Collection")) {
                profile.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        WebElement book2 = driver.findElement(By.id("see-book-Understanding ECMAScript 6"));
        book2.click();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);
        List<WebElement> profile1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile1.size(); i++) {
            if (profile1.get(i).getText().equals("Add To Your Collection")) {
                profile1.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        WebElement book3 = driver.findElement(By.id("see-book-Eloquent JavaScript, Second Edition"));
        book3.click();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);
        List<WebElement> profile3 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile3.size(); i++) {
            if (profile3.get(i).getText().equals("Add To Your Collection")) {
                profile3.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,450)", "");

        Thread.sleep(2000);


        WebElement book4 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        book4.click();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);
        List<WebElement> profile9 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile9.size(); i++) {
            if (profile9.get(i).getText().equals("Add To Your Collection")) {
                profile9.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,450)", "");

        Thread.sleep(2000);

        List<WebElement> profile13 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile13.size(); i++) {
            if (profile13.get(i).getText().equals("Profile")) {
                profile13.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        scroll.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(2000);
        WebElement book1AfterAdding = driver.findElement(By.id("see-book-Speaking JavaScript"));
        Assert.assertTrue(book1AfterAdding.isDisplayed());
        Thread.sleep(2000);
        WebElement book2AfterAdding = driver.findElement(By.id("see-book-Understanding ECMAScript 6"));
        Assert.assertTrue(book2AfterAdding.isDisplayed());
        Thread.sleep(2000);
        WebElement book3AfterAdding = driver.findElement(By.id("see-book-Eloquent JavaScript, Second Edition"));
        Assert.assertTrue(book3AfterAdding.isDisplayed());
        Thread.sleep(2000);
        WebElement book4AfterAdding = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(book4AfterAdding.isDisplayed());
        Thread.sleep(2000);


    }
}
