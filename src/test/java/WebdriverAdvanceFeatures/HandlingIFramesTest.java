package WebdriverAdvanceFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlingIFramesTest {
    WebDriver wd = null;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
        wd =new ChromeDriver();
        wd.manage().window().maximize();
    }

    @Test(enabled=true)
    public void iFrameOperationsTest() throws InterruptedException {
        wd.get("http://demo.guru99.com/test/guru99home/");
        System.out.println(wd.getTitle());
        if(wd.findElement(By.xpath("//iframe[@id=\"a077aa5e\"]")).isDisplayed()) {
            System.out.println("Iframe is present");
        }

        wd.switchTo().frame(wd.findElement(By.xpath("//iframe[@id=\"a077aa5e\"]")));
        Thread.sleep(3000);
        System.out.println("Window handles available are : "+wd.getWindowHandles().size());
        System.out.println("successfully switch to the iframe with the id as =  a077aa5e");
        wd.findElement(By.xpath("html/body/a/img")).click();

        System.out.println("Iframe title :" + wd.getTitle());
        Thread.sleep(3000);
        System.out.println("Iframe switch is done");
        wd.switchTo().defaultContent();
        System.out.println("page title for the default content window : "+ wd.getTitle());
        Thread.sleep(10000);
        //wd.switchTo().parentFrame();
        wd.quit();
    }

    @Test(enabled=true)
    public void iframeSwitch() {
        wd.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
        wd.switchTo().frame(wd.findElement(By.xpath("//div[@id='eduFooterWrap']//iframe[1]")));
        wd.findElement(By.xpath("//input[@name='name']")).sendKeys("SoftwareTestingHelp.com");
        wd.close();
    }
}
