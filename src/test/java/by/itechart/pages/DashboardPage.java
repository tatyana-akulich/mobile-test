package by.itechart.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    By greetingSection = AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    By rankSection = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"rank-progress-card\"]/android.view.ViewGroup[1]");
    By fqvCard = AppiumBy.accessibilityId("FQV-card");
    By g0vCard = AppiumBy.accessibilityId("G0V-card");
    By tgvCard = AppiumBy.accessibilityId("TGV-card");
    By coachesSection = AppiumBy.accessibilityId("metric-section-coaches");
    String verticalScrollToSection = "new UiScrollable (new UiSelector().className(\"android.widget.ScrollView\"))" +
            ".setAsVerticalList().scrollIntoView(new UiSelector().description(\"%s\"))";
    String teamsOverviewDescription = "metric-section-teams-overview";
    String logoDescription = "shared-optavia-logo";
    String rankProgressCardDescription = "rank-progress-card";
    String coachesDescription = "metric-section-coaches";

    public String getCoachesDescription() {
        return coachesDescription;
    }

    public String getRankProgressCardDescription() {
        return rankProgressCardDescription;
    }

    public String getTeamsOverviewDescription() {
        return teamsOverviewDescription;
    }

    public String getLogoDescription() {
        return logoDescription;
    }

    public DashboardPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public WebElement getGreetingSection() {
        return driver.findElement(greetingSection);
    }

    public WebElement getRankSection() {
        return driver.findElement(rankSection);
    }

    public WebElement getCoachesSection() {
        return driver.findElement(coachesSection);
    }


    public WebElement getFqvCard() {
        return driver.findElement(fqvCard);
    }

    public void flingToNextCard() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable" +
                "(new UiSelector().className(\"android.widget.HorizontalScrollView\")).setAsHorizontalList().flingToEnd(1)"));
    }

    public void flingToCard(String title) {
        CardPage cardPage = new CardPage(driver);
        while (!cardPage.getTitle().getText().equals(title)) {
            if (!cardPage.getTitle().getText().equals("Total Generation Volume")) {
                flingToNextCard();
            } else {
                flingCardsToBeginning();
            }
        }
    }

    public void flingCardsToBeginning() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable" +
                "(new UiSelector().className(\"android.widget.HorizontalScrollView\")).setAsHorizontalList().flingToBeginning(1)"));
    }

    public By getFqvCardLocator() {
        return fqvCard;
    }

    public WebElement getG0vCard() {
        return driver.findElement(g0vCard);
    }

    public WebElement getTgvCard() {
        return driver.findElement(tgvCard);
    }

    public WebElement scrollToSection(String section) {
        return driver.findElement(AppiumBy.androidUIAutomator(String.format(verticalScrollToSection, section)));
    }

    public WebElement scrollToCards() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector().className(\"android.widget.ScrollView\"))" +
                ".setAsVerticalList().scrollIntoView(new UiSelector().className(\"android.widget.HorizontalScrollView\"))"));
    }
}
