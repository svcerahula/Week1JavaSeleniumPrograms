package WebdriverAdvanceFeatures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class HandleAlertsTest {
    WebDriver wd = null;
    PropertyManager inst = PropertyManager.getInstance();

    @BeforeMethod
    public void setupEnvForChromeOptions() {
        System.setProperty(inst.getChromeDriverAttrName(),inst.getChromeDriverPath());
        wd = new ChromeDriver();
    }

    /*
    Testcase to try out different actions available for web based Alert handling
     */
    @Test
    public void alertActionsTest() throws InterruptedException {
        wd.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
        //implement explicit wait for the try it button in the above page
        WebDriverWait wait = new WebDriverWait(wd,20);
        WebElement tryItButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='content']/button")));
        tryItButton.click();
        Alert alert = wd.switchTo().alert();
        System.out.println("text within the alert is : "+ alert.getText());
        alert.accept(); //click on Yes for the alert popup
        Thread.sleep(3000);
        wd.findElement(By.xpath("//*[@id='content']/button")).click();
        Thread.sleep(3000);
        alert.dismiss(); // to cancel the alert

        wd.close();
    }
}
