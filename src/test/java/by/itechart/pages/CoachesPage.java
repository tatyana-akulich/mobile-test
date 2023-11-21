package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoachesPage extends BasePage {

    By title = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"metric-section-title\" and @text=\"Coaches\"]");
    By infoIcon = AppiumBy.androidUIAutomator("new UiSelector().description(\"metric-section-coaches\").childSelector(new UiSelector().description(\"info\"))");
    String lineTitle = "new UiSelector().description(\"metric-%s-coaches\").childSelector(new UiSelector().description(\"metric-title\"))";
    String lineValue = "new UiSelector().description(\"metric-%s-coaches\").childSelector(new UiSelector().description(\"metric-value\"))";


    public CoachesPage(AndroidDriver androidDriver) {
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
