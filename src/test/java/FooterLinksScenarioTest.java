import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyManager;
import utilities.UITestUtilities;

import java.util.*;
import java.util.concurrent.TimeUnit;
import PageObjectLibraries.AmazonIndiaHomePage;

public class FooterLinksScenarioTest {
    WebDriver wd=null;
    AmazonIndiaHomePage amazonPageInst=null;
    PropertyManager inst = PropertyManager.getInstance();
    public String amzUrl = inst.getAmazonINUrl();

    /*
    Set all the environment variables for Browser options
    Create PageFactory objects t access elements in the UI page
     */
    @BeforeMethod
    public void setEnvForSeleniumWebDriverTests() {
        System.setProperty(inst.getChromeDriverAttrName(),inst.getChromeDriverPath());
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap();
        prefs.put(inst.getBrowserNotificationFlag(),2); // allow = 1 , block=2 browser notifications
        options.setExperimentalOption("prefs",prefs);
        wd = new ChromeDriver(options);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        amazonPageInst = PageFactory.initElements(wd,AmazonIndiaHomePage.class);
    }

    /*
    Testcase to perform the following :
     * Open www.amazon.in site, and get all the footer section links.
     * Go to each footer section links and open the link and get the Page title for each of the page.
     * Finally come back to the Amazon homepage site or parent window or move back to the homepage.
     */
    @Test
    public void clickOnAllFooterLinks() {
        wd.get(amzUrl);
        String startWindowHandle = wd.getWindowHandle();
        String firstPageTitle = wd.getTitle();
        System.out.print("First page title : "+ firstPageTitle);
        //find all footer section links
        List<WebElement> footerLinks = amazonPageInst.returnAllClickableLinksInFooterSection();

        System.out.println("Complete size of all links : "+ footerLinks.size());
        for(WebElement el : footerLinks) {
            System.out.println("Link text is : "+el.getText() + ". Link is : "+el.getAttribute("href"));
            UITestUtilities.openLinkInNewTab(el);
        }

        List<String> allWindowsHandle = new ArrayList<>(wd.getWindowHandles());
        Iterator it = allWindowsHandle.iterator();
        while(it.hasNext()) {
            wd.switchTo().window(it.next().toString());
            System.out.println("URL Is : "+ wd.getCurrentUrl() +". Page Title is : "+ wd.getTitle());
        }

        System.out.println("Switch to primary window");
        wd.switchTo().window(startWindowHandle);
        if(firstPageTitle.equals(wd.getTitle())){
            System.out.println("Successfully moved back to first HomePage Amazon Ecommerce page of India");
        } else {
            Assert.fail("Mismatch in Page title value . Expected : "+firstPageTitle+ ". Actual value : "+ wd.getTitle());
        }
    }

    @AfterMethod
    public void closeSetup() {
        wd.quit();
    }

}
