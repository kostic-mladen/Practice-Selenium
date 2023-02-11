package Homework23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class DemoQa {

    WebDriver driver;
    WebDriverWait wait;

    JavascriptExecutor scroll;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void pageSetUp() {

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        scroll = (JavascriptExecutor) driver;
        driver.navigate().to("https://demoqa.com/login");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("suitor22");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Bootcamp22@");


        scroll.executeScript("window.scrollBy(0,450)", "");

        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        Assert.assertTrue(driver.findElement(By.id("submit")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.className("rt-noData")).isDisplayed());

    }

    @Test(priority = 10)
    public void addOneBook() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        scroll.executeScript("window.scrollBy(0, 900)", "");

        Thread.sleep(2000);

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("see-book-Git Pocket Guide")));

        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,450)", "");

        WebElement addToColection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColection.click();

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

    @Test(priority = 20)
    public void addTwoBooks() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        scroll.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(2000);

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Git Pocket Guide")));

        scroll.executeScript("window.scrollBy(0,900)", "");

        WebElement book1 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        WebElement addToColection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColection.click();

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-left.fullButton")));

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Designing Evolvable Web APIs with ASP.NET")));

        WebElement book2 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        book2.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        WebElement addToColection1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColection1.click();

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> profile12 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile12.size(); i++) {
            if (profile12.get(i).getText().equals("Profile")) {
                profile12.get(i).click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Learning JavaScript Design Patterns")));

        WebElement book1AfterAdding = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(book1AfterAdding.isDisplayed());

        WebElement book2AfterAdding = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(book2AfterAdding.isDisplayed());

    }

    @Test(priority = 30)
    public void addThreeBooks() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        scroll.executeScript("window.scrollBy(0,900)", "");

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }
        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Speaking JavaScript")));

        WebElement book1 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile.size(); i++) {
            if (profile.get(i).getText().equals("Add To Your Collection")) {
                profile.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-You Don't Know JS")));

        WebElement book2 = driver.findElement(By.id("see-book-You Don't Know JS"));
        book2.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile1.size(); i++) {
            if (profile1.get(i).getText().equals("Add To Your Collection")) {
                profile1.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Programming JavaScript Applications")));

        WebElement book3 = driver.findElement(By.id("see-book-Programming JavaScript Applications"));
        book3.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

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

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> profile12 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile12.size(); i++) {
            if (profile12.get(i).getText().equals("Profile")) {
                profile12.get(i).click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Speaking JavaScript")));

        WebElement book1AfterAdding = driver.findElement(By.id("see-book-Speaking JavaScript"));
        Assert.assertTrue(book1AfterAdding.isDisplayed());

        WebElement book2AfterAdding = driver.findElement(By.id("see-book-You Don't Know JS"));
        Assert.assertTrue(book2AfterAdding.isDisplayed());

        WebElement book3AfterAdding = driver.findElement(By.id("see-book-Programming JavaScript Applications"));
        Assert.assertTrue(book3AfterAdding.isDisplayed());

    }

    @Test(priority = 40)
    public void addFourBooks() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

        scroll.executeScript("window.scrollBy(0,900)", "");

        List<WebElement> bookStoreButton = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStoreButton.size(); i++) {
            if (bookStoreButton.get(i).getText().equals("Book Store")) {
                bookStoreButton.get(i).click();
                break;
            }
        }

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Speaking JavaScript")));

        WebElement book1 = driver.findElement(By.id("see-book-Speaking JavaScript"));
        book1.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile.size(); i++) {
            if (profile.get(i).getText().equals("Add To Your Collection")) {
                profile.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Understanding ECMAScript 6")));

        WebElement book2 = driver.findElement(By.id("see-book-Understanding ECMAScript 6"));
        book2.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile1 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile1.size(); i++) {
            if (profile1.get(i).getText().equals("Add To Your Collection")) {
                profile1.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Eloquent JavaScript, Second Edition")));

        WebElement book3 = driver.findElement(By.id("see-book-Eloquent JavaScript, Second Edition"));
        book3.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile3 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile3.size(); i++) {
            if (profile3.get(i).getText().equals("Add To Your Collection")) {
                profile3.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,900)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,450)", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Designing Evolvable Web APIs with ASP.NET")));

        WebElement book4 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        book4.click();

        scroll.executeScript("window.scrollBy(0,900)", "");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-right.fullButton")));

        List<WebElement> profile9 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < profile9.size(); i++) {
            if (profile9.get(i).getText().equals("Add To Your Collection")) {
                profile9.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        scroll.executeScript("window.scrollBy(0,450)", "");

        driver.navigate().back();

        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> profile13 = driver.findElements(By.id("item-3"));
        for (int i = 0; i < profile13.size(); i++) {
            if (profile13.get(i).getText().equals("Profile")) {
                profile13.get(i).click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Speaking JavaScript")));

        scroll.executeScript("window.scrollBy(0,450)", "");

        WebElement book1AfterAdding = driver.findElement(By.id("see-book-Speaking JavaScript"));
        Assert.assertTrue(book1AfterAdding.isDisplayed());

        WebElement book2AfterAdding = driver.findElement(By.id("see-book-Understanding ECMAScript 6"));
        Assert.assertTrue(book2AfterAdding.isDisplayed());

        WebElement book3AfterAdding = driver.findElement(By.id("see-book-Eloquent JavaScript, Second Edition"));
        Assert.assertTrue(book3AfterAdding.isDisplayed());

        WebElement book4AfterAdding = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(book4AfterAdding.isDisplayed());

        Thread.sleep(2000);


    }


    @AfterMethod
    public void logOut() throws InterruptedException {

        scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,450)", "");

        List<WebElement> deleteAllBoooks = driver.findElements(By.id("submit"));
        for (int i = 0; i < deleteAllBoooks.size(); i++) {
            if (deleteAllBoooks.get(i).getText().equals("Delete All Books")) {
                deleteAllBoooks.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);
        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
    }

    @AfterClass
    public void chromeClose() {
        driver.quit();

    }
}
