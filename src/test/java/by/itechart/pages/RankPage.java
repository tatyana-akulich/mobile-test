package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RankPage extends BasePage {
    By title = AppiumBy.accessibilityId("rank-progress-title");
    By description = AppiumBy.accessibilityId("rank-progress-description");
    By icon = AppiumBy.accessibilityId("rank-6");
    By progressAndPerformance = AppiumBy.accessibilityId("rank-see-progress");
    By progressBar = AppiumBy.accessibilityId("rank-progress-bar");

    public RankPage(AndroidDriver androidDriver) {
        super(androidDriver);
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
}
