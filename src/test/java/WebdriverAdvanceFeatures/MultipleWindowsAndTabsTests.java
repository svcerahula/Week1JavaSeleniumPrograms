package WebdriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class MultipleWindowsAndTabsTests {
    WebDriver wd = null;


    @BeforeMethod
    public void setupTestEnv() {
        System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
        ChromeOptions options =new ChromeOptions();
        Map<String,Object> prefs = new HashMap();
        prefs.put("profile.default_content_setting_values.notifications","2");
        options.setExperimentalOption("prefs",prefs);
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void  openLinkInNewTab() {
        wd.get("https://wwww.facebook.com");

        String currentWinHandle = wd.getWindowHandle();
        String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        wd.findElement(By.xpath("//a[text()=\"Data Policy\"]")).sendKeys(openLinkInNewTab);

        ArrayList<String> windowHandles = new ArrayList(wd.getWindowHandles());

        wd.switchTo().window(windowHandles.get(1));
        //wd.quit();
    }

    @Test
    public void openNewTabAndGoToANewPage() {
        wd.get("https://wwww.facebook.com");
        ((JavascriptExecutor)wd).executeScript("window.open()");
        ArrayList<String> windowHandles = new ArrayList(wd.getWindowHandles());
        wd.switchTo().window(windowHandles.get(1));
        wd.get("http://www.google.com");
    }

    @AfterMethod
    public void closeBrowser() {
        wd.close();
    }
}
