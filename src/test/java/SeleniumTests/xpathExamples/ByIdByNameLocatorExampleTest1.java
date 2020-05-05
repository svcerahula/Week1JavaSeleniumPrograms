package SeleniumTests.xpathExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import utilities.PropertyManager;
import PageObjectLibraries.*;

public class ByIdByNameLocatorExampleTest1 {

    WebDriver wd=null;
    PropertyManager inst = PropertyManager.getInstance();
    protected final String emailId=inst.getFbEmailId();
    private  final String fbPassword = inst.getFbPassword();
    public String fbUrl = inst.getFbUrl();



    @BeforeMethod
    public void setEnvForSeleniumWebDriverTests() {
        System.setProperty(inst.getChromeDriverAttrName(),inst.getChromeDriverPath());
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap();
        prefs.put(inst.getBrowserNotificationFlag(),2); // allow = 1 , block=2 browser notifications
        options.setExperimentalOption("prefs",prefs);
        wd = new ChromeDriver(options);

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled=false)
    public void LoginFacebookUsingId() {
        wd.get(fbUrl);
        FaceBookLoginPage loginPage = PageFactory.initElements(wd,FaceBookLoginPage.class);
        FaceBookUserPage userPage = PageFactory.initElements(wd,FaceBookUserPage.class);

        //find the element to input the email and enter the value for it.
        loginPage.setEmailId(emailId);


        //find the element to input the email and enter the value for it.
        loginPage.setFBPassword(fbPassword);

        // find the login button and click
        loginPage.clickLogin();

        System.out.println("Successfully logged in FB using page object model , Page factory implementation");
        if(userPage.fbIconIsEnabled()) {
            System.out.println("Facebook button identified");
        } else {
            Assert.fail("element not found error");
        }
    }

    @Test(enabled=false)
    public void LoginFacebookUsingNameAndCssLocator() {
        wd.get(fbUrl);
        //find the element to input the email and enter the value for it.
        wd.findElement(By.name("email")).sendKeys(emailId);


        //find the element to input the email and enter the value for it.
        wd.findElement(By.name("pass")).sendKeys(fbPassword);

        // find the login button and click
        wd.findElement(By.cssSelector("label.login_form_login_button.uiButton.uiButtonConfirm#loginbutton")).click(); // CSS selector for ID
        System.out.println("Successfully logged in FB using By name locator selenium wd");
        if(wd.findElement(By.xpath("//span[text()='Facebook']")) != null) {
            System.out.println("Facebook button identified");
        }

        //click on account settings button
        wd.findElement(By.xpath("//div[text()=\"Account Settings\"]")).click();
        //click on logout
        wd.findElement(By.cssSelector("div.uiScrollableAreaContent li:nth-child(11)")).click(); //use of CSS Locator

        wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(enabled=true)
    public void exampleForDropDown() throws InterruptedException {
        wd.get("https://www.covid19india.org/");
        System.out.println("Page title : "+wd.getTitle());
        Select  selObj1 = new Select(wd.findElement(By.xpath("//select")));
        selObj1.selectByVisibleText("Karnataka");
        Thread.sleep(30);
        WebElement  totalConfirmedCases = wd.findElement
                (By.xpath("//div[@class=\"stats\"]/h5[text()=\"Confirmed\"]/following-sibling::div/h2"));
        System.out.println("get element detail : "+ totalConfirmedCases.getText());
    }

    @AfterMethod
    public void closeSetup() {
        wd.close();
    }
}
