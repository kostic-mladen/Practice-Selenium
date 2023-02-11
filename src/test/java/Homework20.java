
package Cas4;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Homework20 {

    public static void main(String[] args) throws InterruptedException {

        //Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
             //   Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        Cookie cookie2 = new Cookie("userID", "5e2ad821-7a85-4d0f-a148-c7120c2b241f");
        Cookie cookie3 = new Cookie("userName", "suitor22");
        Cookie cookie4 = new Cookie("expires","202023-01-22T16%3A02%3A48.822Z");
        Cookie cookie5 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN1aXRvcjIyIiwicGFzc3dvcmQiOiJCb290Y2FtcDIyQCIsImlhdCI6MTY3Mzc5ODU2OH0.QFTRIemPfmVWKG3nM4EMyp1hKMuQYX4Td5OKx0683AU");

        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.manage().addCookie(cookie5);

        driver.navigate().refresh();

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")){
                bookStoreButton.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,450)", "");

        Thread.sleep(2000);

        List<WebElement> profile= driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile.size(); i++) {
            if (profile.get(i).getText().equals("Add To Your Collection")){
                profile.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,450)", "");

        Thread.sleep(2000);

        List<WebElement> profile1 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile1.size(); i++) {
            if (profile1.get(i).getText().equals("Profile")) {
                profile1.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> store = driver.findElements(By.id("gotoStore"));
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getText().equals("Go To Book Store")) {
                store.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();
        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> profile2= driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile2.size(); i++) {
            if (profile2.get(i).getText().equals("Add To Your Collection")){
                profile2.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> profile3 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile3.size(); i++) {
            if (profile3.get(i).getText().equals("Profile")) {
                profile3.get(i).click();
                break;
            }
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        Thread.sleep(2000);
        WebElement login = driver.findElement(By.linkText("login"));
        login.click();

        String username1 = "suitor22";
        String password1 = "Bootcamp22@";

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys(username1);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(password1);
        Thread.sleep(2000);

         scroll.executeScript("window.scrollBy(0,450)", "");

        WebElement login1 = driver.findElement(By.id("login"));
        login1.click();

        Thread.sleep(2000);

        WebElement book1Afteradding = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(book1Afteradding.isDisplayed());

        WebElement book2Afteradding = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book2Afteradding.isDisplayed());

    }
}
