package SeleniumTests.xpathExamples;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class xpathTests {

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
    }

    @Test(enabled=false)
    public void xpathForCheckBox() {
        WebDriver wd1 = new ChromeDriver();
        wd1.manage().window().maximize();
        wd1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd1.get("http://only-testing-blog.blogspot.in/2014/09/temp.html");
        //To select Cow checkbox using position() function.
        wd1.findElement(By.xpath("(//input[@type='checkbox'])[position()=3]")).click(); //using position function
        wd1.findElement(By.xpath("(//input[@type='checkbox'])[last()-1]")).click(); // last function
        wd1.findElement(By.xpath("(//input[@type='checkbox'])[last()]")).click();

        wd1.close();
    }

    @Test
    public void xpathToFindAllLinksinFBPage() throws IOException {
        WebDriver wd1 = new ChromeDriver();
        wd1.manage().window().maximize();
        wd1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd1.get("https://www.facebook.com");

        // xpath to find textbox //input[@type,"text"]
        wd1.findElement(By.xpath("//input[@type=\"text\" and @aria-label=\"First name\"]")).sendKeys("Churchill");


        List<WebElement> elements = wd1.findElements(By.tagName("a"));

        System.out.println("Printing all the Links available in the FB page");
        for(WebElement el1: elements) {
            System.out.println(el1.getAttribute("href"));
        }

        // select the Male radio button in the FB page

        wd1.findElement(By.xpath("//input[@type=\"radio\"]/following-sibling::label[text()=\"Male\"]")).click(); // made use of following-sibling concept and radio button selection is done here

        File src= ((TakesScreenshot)wd1).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,
                new File("C:\\Rahula Space\\Intellij Idea Projects\\Day1JavaSeleniumWebdriverProj\\screenshots\\fbpage1.png"));
        System.out.println("Successfully clicked on the Male radio button ");

        wd1.close();
    }
}
