package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    By greetingSection = AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    String verticalScrollToSection = "new UiScrollable (new UiSelector().className(\"android.widget.ScrollView\"))" +
            ".setAsVerticalList().scrollIntoView(new UiSelector().description(\"%s\"))";
    CardSection cardSection;
    CoachesSection coachesSection;
    RankSection rankSection;
    TeamsOverviewSection teamsOverviewSection;
    LogoSection logoSection;

    public DashboardPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        cardSection = new CardSection(driver);
        coachesSection = new CoachesSection(driver);
        rankSection = new RankSection(driver);
        teamsOverviewSection = new TeamsOverviewSection(driver);
        logoSection = new LogoSection(driver);
    }

    public CardSection cardSection() {
        return cardSection;
    }

    public CoachesSection coachesSection() {
        return coachesSection;
    }

    public RankSection rankSection() {
        return rankSection;
    }

    public TeamsOverviewSection teamsOverviewSection() {
        return teamsOverviewSection;
    }

    public LogoSection logoSection() {
        return logoSection;
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
