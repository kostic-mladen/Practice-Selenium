package Homework19.HomeworkPage;

import Homework19.HomeworkBase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    //


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (css = ".button.secondary.radius")
    WebElement Logout;

    public void clickOnLogout(){
        Logout.click();
    }
}


