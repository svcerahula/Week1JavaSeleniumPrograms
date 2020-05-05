package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class UITestUtilities {

    public static final String pressCtrlEnter = Keys.chord(Keys.CONTROL,Keys.ENTER);
    public void performTakingScreenshot(WebDriver wd, String absoluteDestPath) throws IOException {
        File srcfile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcfile, new File(absoluteDestPath));
    }
    public static void openLinkInNewTab(WebElement linkElement) {
        linkElement.sendKeys(pressCtrlEnter);
    }
}
