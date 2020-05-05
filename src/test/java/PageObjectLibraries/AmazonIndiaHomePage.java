package PageObjectLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AmazonIndiaHomePage {

    @FindBy(how= How.XPATH,using="//div[@id=\"navFooter\"]")
    WebElement footerSection;

    public WebElement getFooterSectionElement() {
        return footerSection;
    }
    public List<WebElement> returnAllClickableLinksInFooterSection() {
        return footerSection.findElements(By.tagName("a"));
    }
}
