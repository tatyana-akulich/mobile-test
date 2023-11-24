package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TeamsOverviewSection extends BasePage {
    String teamsOverviewDescription = "metric-section-teams-overview";
    By title = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"metric-section-title\" and @text=\"Teams Overview\"]");
    By infoIcon = AppiumBy.androidUIAutomator("new UiSelector().description(\"metric-section-teams-overview\").childSelector(new UiSelector().description(\"info\"))");
    String lineTitle = "new UiSelector().description(\"metric-%s-teams\").childSelector(new UiSelector().description(\"metric-title\"))";
    String lineValue = "new UiSelector().description(\"metric-%s-teams\").childSelector(new UiSelector().description(\"metric-value\"))";

    public TeamsOverviewSection(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getTeamsOverviewDescription() {
        return teamsOverviewDescription;
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
