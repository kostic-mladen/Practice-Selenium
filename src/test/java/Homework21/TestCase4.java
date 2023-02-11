package Homework21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase4 {

    // Verify unsuccessful log in with invalid username and valid password input

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practicePage = driver.findElement(By.id("menu-item-20"));
        practicePage.click();

        WebElement loginPage = driver.findElement(By.linkText("Test Login Page"));
        loginPage.click();

        String userN = "student";
        String pass = "Password123";

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(userN.toUpperCase());

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);

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
