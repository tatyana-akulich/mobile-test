package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TeamsOverviewPage extends BasePage{
    By title = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"metric-section-title\" and @text=\"Teams Overview\"]");
    By infoIcon = AppiumBy.androidUIAutomator("new UiSelector().description(\"metric-section-teams-overview\").childSelector(new UiSelector().description(\"info\"))");
    String lineTitle = "new UiSelector().description(\"metric-%s-teams\").childSelector(new UiSelector().description(\"metric-title\"))";
    String lineValue = "new UiSelector().description(\"metric-%s-teams\").childSelector(new UiSelector().description(\"metric-value\"))";
    public TeamsOverviewPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getInfoIcon() {
        return driver.findElement(infoIcon);
    }

    public WebElement getTitle(String title) {
        return driver.findElement(AppiumBy.androidUIAutomator(String.format(lineTitle, title)));
    }

    public WebElement getValue(String title) {
        return driver.findElement(AppiumBy.androidUIAutomator(String.format(lineValue, title)));
    }
}
