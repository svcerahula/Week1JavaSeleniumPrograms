package WebdriverAdvanceFeatures;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import utilities.UITestUtilities;

public class ActionsKeyboardMouseTests {
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

    /*
    Testcase to perform a keyboard action of typing a word string in capital letters using Shift+alphabets
    Keyboard functionality
     */
    @Test(enabled=false)
    public void typeLettersInUpperCase() throws IOException {
        wd.get("https://demoqa.com/autocomplete/");

        Actions actions = new Actions(wd);

        WebElement tags = wd.findElement(By.cssSelector("input#tags"));
        actions.keyDown(tags, Keys.SHIFT).sendKeys("Rahula").keyUp(tags,Keys.SHIFT).build().perform();

        File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Rahula Space\\Intellij Idea Projects" +
                "\\Day1JavaSeleniumWebdriverProj\\screenshots\\actionsUpperCasewordsEntered.png"));

    }

    /*
    perform mouse hover on a link in a page - the link changes color
     */
    @Test
    public void performMouseHover() throws IOException {
        wd.get("https://www.facebook.com");

        WebElement emailid = wd.findElement(By.id("email"));

        Actions builder =new Actions(wd);

        builder.moveToElement(emailid).click().keyDown(emailid, Keys.SHIFT)
                .sendKeys(emailid, "hello")
                .keyUp(emailid, Keys.SHIFT)
                .doubleClick(emailid)
                .contextClick()
                .build().perform();
        String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
        UITestUtilities utils = new UITestUtilities();
        utils.performTakingScreenshot(wd,"C:\\Rahula Space\\Intellij Idea Projects" +
                "\\Day1JavaSeleniumWebdriverProj\\screenshots\\mouseHover1.png");
    }

    @AfterMethod
    public void closeSetup() {
        wd.close();
    }
}
