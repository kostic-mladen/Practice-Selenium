package Homework21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase2 {

    //TestCase1 - Verify that user can not log in with empty password field

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practicePage = driver.findElement(By.id("menu-item-20"));
        practicePage.click();

        WebElement loginPage = driver.findElement(By.linkText("Test Login Page"));
        loginPage.click();

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(Keys.NULL);

        WebElement submitBUtton = driver.findElement(By.id("submit"));
        submitBUtton.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement userNameField = driver.findElement(By.id("username"));
        Assert.assertTrue(userNameField.isDisplayed());

        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField.isDisplayed());

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());


    }
}
