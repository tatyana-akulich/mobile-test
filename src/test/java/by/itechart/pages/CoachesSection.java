package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoachesSection extends BasePage {
    By coachesSection = AppiumBy.accessibilityId("metric-section-coaches");
    By title = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"metric-section-title\" and @text=\"Coaches\"]");
    By infoIcon = AppiumBy.androidUIAutomator("new UiSelector().description(\"metric-section-coaches\").childSelector(new UiSelector().description(\"info\"))");
    String lineTitle = "new UiSelector().description(\"metric-%s-coaches\").childSelector(new UiSelector().description(\"metric-title\"))";
    String lineValue = "new UiSelector().description(\"metric-%s-coaches\").childSelector(new UiSelector().description(\"metric-value\"))";

    public CoachesSection(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public WebElement getCoachesSection() {
        return driver.findElement(coachesSection);
    }

    public WebElement getTitle() {
        if (platform.equals("android")) {
            return driver.findElement(title);
        } else if (platform.equals("ios")) {
            driver.findElement(By.id(""));
        }
        return null;
    }

    public WebElement getInfoIcon() {
        if (platform.equals("android")) {
            return driver.findElement(infoIcon);
        } else if (platform.equals("ios")) {
            driver.findElement(By.id(""));
        }
        return null;
    }

    public WebElement getTitle(String title) {
        if (platform.equals("android")) {
            return driver.findElement(AppiumBy.androidUIAutomator(String.format(lineTitle, title)));
        } else if (platform.equals("ios")) {
            driver.findElement(By.id(""));
        }
        return null;
    }

    public WebElement getValue(String title) {
        if (platform.equals("android")) {
            return driver.findElement(AppiumBy.androidUIAutomator(String.format(lineValue, title)));
        } else if (platform.equals("ios")) {
            driver.findElement(By.id(""));
        }
        return null;
    }
}
