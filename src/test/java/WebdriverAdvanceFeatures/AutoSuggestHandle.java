package WebdriverAdvanceFeatures;

import PageObjectLibraries.GoogleSearchHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoSuggestHandle {
    WebDriver wd = null;
    GoogleSearchHomePage googlePage = null;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Rahula Space\\Drivers\\chromedriver_win32_ver79\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications",2);
        options.setExperimentalOption("prefs",prefs);
        wd = new ChromeDriver(options);
        googlePage = PageFactory.initElements(wd, GoogleSearchHomePage.class);
    }

    @Test
    public void autoSuggestSelect() {
        wd.get(googlePage.googleHomePageUrl);
        googlePage.typeTextInSearchBox("Selenium");

        List<WebElement> options = googlePage.explicitWaitForListBoxElementsToBeVisible(wd,10);

        System.out.print("total no of options : "+ options.size());
        for(WebElement el : options) {
            System.out.println(el.getText());
        }
        for(WebElement el : options) {
            if(el.getText().equalsIgnoreCase("selenium download")) {
                el.click();
                break;
            }
        }

        googlePage.explicitWaitForTextToAvailableInSearchResultsPage(googlePage.firstSearchResultXpath
                ,wd,10);

        wd.close();
    }
}
