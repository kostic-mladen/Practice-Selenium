package Homework22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class homework {

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
        Cookie cookie4 = new Cookie("expires","2023-01-20T11%3A11%3A35.044Z");
        Cookie cookie5 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN1aXRvcjIyIiwicGFzc3dvcmQiOiJCb290Y2FtcDIyQCIsImlhdCI6MTY3MzYwODI5NX0.6K0qXDtkuLfBjKOeESBtofaDSH_OtX1rD4mUIU5FUSQ");

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

        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/books?book=9781449325862"));

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

        //WebElement logOutButton = driver.findElement(By.id("submit"));
       //logOutButton.click();

        /*String expectedUrl = "https://demoqa.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement userNameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));

        Assert.assertTrue(userNameField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());*/

       /* boolean button = false;
        try {
            button = logOutButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(button);*/

    }
}
