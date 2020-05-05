package SeleniumTests.xpathExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyManager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverWaitExamples {

    WebDriver wd = null;
    PropertyManager inst = PropertyManager.getInstance();

    @BeforeMethod
    public void setEnvForSeleniumWebDriverTests() {
        System.setProperty(inst.getChromeDriverAttrName(),inst.getChromeDriverPath());
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap();
        prefs.put(inst.getBrowserNotificationFlag(),2); // allow = 1 , block=2 browser notifications
        options.setExperimentalOption("prefs",prefs);
        wd = new ChromeDriver(options);
    }

    /*
    Implicit Wait for
     */
    @Test
    public void exampleForImplicitWait() throws InterruptedException
    {
        String eTitle = "Demo Guru99 Page";
        String aTitle = "" ;
        // launch Chrome and redirect it to the Base URL
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://demo.guru99.com/test/guru99home/" );
        //Maximizes the browser window
        wd.manage().window().maximize() ;
        //get the actual value of the title
        aTitle = wd.getTitle();
        //compare the actual title with the expected title
        if (aTitle.equals(eTitle))
        {
            System.out.println( "Test Passed") ;
        }
        else {
            System.out.println( "Test Failed" );
        }
        //close browser
        wd.close();
    }

    @Test
    public void testExplicitWaitWebDriver() throws InterruptedException {
        // saving the GUI element reference into a "element" variable of WebElement type
        WebElement element = wd.findElement(By.id("Email"));
        // entering username
        element.sendKeys("dummy@gmail.com");
        element.sendKeys(Keys.RETURN);
        // entering password
        wd.findElement(By.id("Passwd")).sendKeys("password");
            // clicking signin button
        wd.findElement(By.id("signIn")).click();
            // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(wd,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
            // click on the compose button as soon as the "compose" button is visible
        wd.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
    }
}
