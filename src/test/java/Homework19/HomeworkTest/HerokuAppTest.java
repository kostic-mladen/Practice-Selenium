package Homework19.HomeworkTest;

import Homework19.HomeworkBase.BaseTest;
import Homework19.HomeworkPage.LoginPage;
import Homework19.HomeworkPage.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HerokuAppTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() throws IOException {
        driver.manage().window().maximize();
        driver.get(signInUrl);
        signInPage = new SignInPage();
        loginPage = new LoginPage();
    }

    @Test
    public void signIn() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        signInPage.inputUsername(validUsername);
        signInPage.inputPassword(validPassword);
        signInPage.clickSubmit();
        String expectedURL = excelReader.getStringData("URL", 1,1);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(loginPage.Logout.isDisplayed());
    }

    @Test
    public void userCanLogOut() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        signInPage.inputUsername(validUsername);
        signInPage.inputPassword(validPassword);
        signInPage.clickSubmit();
        loginPage.clickOnLogout();
        Assert.assertFalse(isDisplayed(loginPage.Logout));
        Assert.assertTrue(signInPage.Username.isDisplayed());
        Assert.assertTrue(signInPage.Password.isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            signInPage.inputUsername(invalidUsername);
            signInPage.inputPassword(validPassword);
            signInPage.clickSubmit();
            Assert.assertFalse(isDisplayed(loginPage.Logout));
            String expectedURL = excelReader.getStringData("URL", 1,0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(signInPage.Username.isDisplayed());
            Assert.assertTrue(signInPage.Password.isDisplayed());
        }
    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            signInPage.inputUsername(validUsername);
            signInPage.inputPassword(invalidPassword);
            signInPage.clickSubmit();
            Assert.assertFalse(isDisplayed(loginPage.Logout));
            String expectedURL = excelReader.getStringData("URL", 1,0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(signInPage.Username.isDisplayed());
            Assert.assertTrue(signInPage.Password.isDisplayed());
        }
    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            signInPage.inputUsername(invalidUsername);
            signInPage.inputPassword(invalidPassword);
            signInPage.clickSubmit();
            Assert.assertFalse(isDisplayed(loginPage.Logout));
            String expectedURL = excelReader.getStringData("URL", 1,0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(signInPage.Username.isDisplayed());
            Assert.assertTrue(signInPage.Password.isDisplayed());
        }
    }
}


