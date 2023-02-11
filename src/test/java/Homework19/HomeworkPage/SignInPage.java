package Homework19.HomeworkPage;

import Homework19.HomeworkBase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseTest {

    public SignInPage() {
        PageFactory.initElements(driver, this);

    }

    public @FindBy(id = "username")
    WebElement Username;

    public @FindBy(id = "password")
    WebElement Password;

    public @FindBy(className = "radius")
    WebElement Submit;

    public void inputUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void inputPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickSubmit() {
        Submit.click();
    }

}
