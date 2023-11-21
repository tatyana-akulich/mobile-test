package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardPage extends BasePage {
    By title = AppiumBy.accessibilityId("card-title");
    By mainValue = AppiumBy.accessibilityId("card-main-value");
    By infoIcon = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"info\"])[1]");
    By thisMonthTitle = AppiumBy.accessibilityId("card-projected-this-month-title");
    By thisMonthValue = AppiumBy.accessibilityId("card-projected-this-month-value");
    By sameTimeLastMonthTitle = AppiumBy.accessibilityId("card-same-last-month-title");
    By sameTimeLastMonthValue = AppiumBy.accessibilityId("card-same-last-month-value");
    By lastMonthTitle = AppiumBy.accessibilityId("card-last-month-total-title");
    By lastMonthValue = AppiumBy.accessibilityId("card-last-month-total-value");

    public CardPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getMainValue() {
        return driver.findElement(mainValue);
    }

    public WebElement getInfoIcon() {
        return driver.findElement(infoIcon);
    }

    public WebElement getThisMonthTitle() {
        return driver.findElement(thisMonthTitle);
    }

    public WebElement getThisMonthValue() {
        return driver.findElement(thisMonthValue);
    }

    public WebElement getLastMonthTitle() {
        return driver.findElement(lastMonthTitle);
    }

    public WebElement getLastMonthValue() {
        return driver.findElement(lastMonthValue);
    }

    public WebElement getSameTimeLastMonthTitle() {
        return driver.findElement(sameTimeLastMonthTitle);
    }

    public WebElement getSameTimeLastMonthValue() {
        return driver.findElement(sameTimeLastMonthValue);
    }
}
