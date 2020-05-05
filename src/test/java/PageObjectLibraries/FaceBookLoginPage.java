package PageObjectLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FaceBookLoginPage {

    @FindBy(how= How.ID,using="email")
    WebElement emailId; // webelement for email id username for fb login page

    @FindBy(how=How.ID,using="pass")
    WebElement password;

    @FindBy(how=How.ID,using="loginbutton")
    WebElement loginButton;

    public void setEmailId(String strEmail) {
        emailId.sendKeys(strEmail);
    }

    public void setFBPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() { loginButton.click(); }

}
