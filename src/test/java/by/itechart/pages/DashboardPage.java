package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    By greetingSection = AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    String verticalScrollToSection = "new UiScrollable (new UiSelector().className(\"android.widget.ScrollView\"))" +
            ".setAsVerticalList().scrollIntoView(new UiSelector().description(\"%s\"))";

    public DashboardPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public CardSection cardSection() {
        return new CardSection(driver);
    }

    public CoachesSection coachesSection() {
        return new CoachesSection(driver);
    }

    public RankSection rankSection() {
        return new RankSection(driver);
    }

    public TeamsOverviewSection teamsOverviewSection() {
        return new TeamsOverviewSection(driver);
    }

    public LogoSection logoSection() {
        return new LogoSection(driver);
    }

    public WebElement getGreetingSection() {
        return driver.findElement(greetingSection);
    }

    public WebElement scrollToSection(String section) {
        return driver.findElement(AppiumBy.androidUIAutomator(String.format(verticalScrollToSection, section)));
    }

    public WebElement scrollToCards() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".setAsVerticalList().scrollIntoView(new UiSelector().className(\"android.widget.HorizontalScrollView\"))"));
    }
}
