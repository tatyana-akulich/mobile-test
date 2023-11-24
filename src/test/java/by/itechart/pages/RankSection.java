package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RankSection extends BasePage {
    By rankSection = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"rank-progress-card\"]/android.view.ViewGroup[1]");
    String rankProgressCardDescription = "rank-progress-card";
    By title = AppiumBy.accessibilityId("rank-progress-title");
    By description = AppiumBy.accessibilityId(rankProgressCardDescription);
    By icon = AppiumBy.accessibilityId("rank-6");
    By progressAndPerformance = AppiumBy.accessibilityId("rank-see-progress");
    By progressBar = AppiumBy.accessibilityId("rank-progress-bar");

    public RankSection(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getDescription() {
        return driver.findElement(description);
    }

    public WebElement getIcon() {
        return driver.findElement(icon);
    }

    public WebElement getProgressAndPerformance() {
        return driver.findElement(progressAndPerformance);
    }

    public WebElement getProgressBar() {
        return driver.findElement(progressBar);
    }

    public String getRankProgressCardDescription() {
        return rankProgressCardDescription;
    }

    public WebElement getRankSection() {
        return driver.findElement(rankSection);
    }
}
