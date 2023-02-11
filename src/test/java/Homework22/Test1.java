package Homework22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        scroll.executeScript("window.scrollBy(0, 900)", "");

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Git Pocket Guide")));

        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> addToCollection = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addToCollection.size(); i++) {
            if (addToCollection.get(i).getText().equals("Add To Your Collection")) {
                addToCollection.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        List<WebElement> profile1 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile1.size(); i++) {
            if (profile1.get(i).getText().equals("Profile")) {
                profile1.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Git Pocket Guide")));
        WebElement book1AfterAdding = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1AfterAdding.isDisplayed());

    }

}
