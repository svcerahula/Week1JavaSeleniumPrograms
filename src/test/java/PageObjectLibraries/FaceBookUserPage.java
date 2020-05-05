package PageObjectLibraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FaceBookUserPage {

    @FindBy(how= How.CSS,using="a[title=\"Go to Facebook Home\"]")
    WebElement fbIcon;

    public boolean fbIconIsEnabled() {
        return fbIcon.isEnabled();
    }
}
