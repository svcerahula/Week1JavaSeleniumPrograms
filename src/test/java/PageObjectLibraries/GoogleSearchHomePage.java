package PageObjectLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchHomePage {
    public final String googleHomePageUrl = "https://www.google.com";
    private final String listBoxXpath = "//ul[@role=\"listbox\"]/li";
    public  final String firstSearchResultXpath = "//h3[text()=\"Downloads - Selenium\"]";
    @FindBy(how= How.XPATH,using="//input[@type=\"text\" and @title=\"Search\"]")
    WebElement searchBox;

    public void typeTextInSearchBox(String text) {
        searchBox.sendKeys(text);
    }

    public List<WebElement> explicitWaitForListBoxElementsToBeVisible(WebDriver wd,int timeUnitInSeconds) {
        WebDriverWait wait = new WebDriverWait(wd,timeUnitInSeconds);
        return wait.until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(By.xpath(listBoxXpath)));
    }

    public void explicitWaitForTextToAvailableInSearchResultsPage(String xpathString,WebDriver wd,int timeUnitInSeconds) {
        WebDriverWait wait = new WebDriverWait(wd,timeUnitInSeconds);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath(xpathString)));
    }
}
