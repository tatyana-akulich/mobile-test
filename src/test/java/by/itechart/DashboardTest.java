package by.itechart;

import by.itechart.pages.*;
import by.itechart.util.Parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DashboardTest extends BaseTest {
    DashboardPage dashboardPage;
    @Test
    public void testDashboard() {
        log.info("Start Dashboard test");
        log.info("Login with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        dashboardPage = new DashboardPage(driver);
        log.debug("Wait for page loading");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.cardSection().getFqvCardLocator()));
        log.info("Verify dashboard elements presence");
        verifyPresenceOfDashboardElements();
        log.info("Verify rank progress card elements");
        verifyRankProgressCard();
        log.info("Verify sliding cards elements");
        verifySlidingCards();
        log.info("Verify coaches section elements");
        verifyCoachesSection();
        log.info("Verify teams overview section elements");
        verifyTeamsOverviewSection();
    }

    void verifyPresenceOfDashboardElements() {
        log.debug("Check that greeting card is displayed");
        assertTrue(dashboardPage.getGreetingSection().isDisplayed());
        log.debug("Check that rank section is displayed");
        assertTrue(dashboardPage.rankSection().getRankSection().isDisplayed());
        log.debug("Check that Frontline Qualifying Volume card is displayed");
        assertTrue(dashboardPage.cardSection().getFqvCard().isDisplayed());
        log.warn("Fling to card Generation 0 Volume");
        dashboardPage.cardSection().scrollToCard("G0V-card");
        log.debug("Check that card Generation 0 Volume is displayed");
        assertTrue(dashboardPage.cardSection().getG0vCard().isDisplayed());
        log.warn("Fling to card Total Generation Volume");
        dashboardPage.cardSection().scrollToCard("TGV-card");
        log.debug("Check that Total Generation Volume card is displayed");
        assertTrue(dashboardPage.cardSection().getTgvCard().isDisplayed());
        log.debug("Check that coaches section is displayed");
        assertTrue(dashboardPage.coachesSection().getCoachesSection().isDisplayed());
        log.warn("Scroll to teams overview");
        WebElement teamsOverview = dashboardPage.scrollToSection(dashboardPage.teamsOverviewSection().getTeamsOverviewDescription());
        log.debug("Check that teams overview section is displayed");
        assertTrue(teamsOverview.isDisplayed());
        log.warn("Scroll to logo");
        WebElement logo = dashboardPage.scrollToSection(dashboardPage.logoSection().getLogoDescription());
        log.debug("Check that logo is displayed");
        assertTrue(logo.isDisplayed());
    }

    void verifyRankProgressCard() {
        log.warn("Scroll to rank progress section");
        dashboardPage.scrollToSection(dashboardPage.rankSection().getRankProgressCardDescription());
        log.debug("Check that title is displayed");
        assertTrue(dashboardPage.rankSection().getTitle().isDisplayed());
        log.debug("Check that description is displayed");
        assertTrue(dashboardPage.rankSection().getDescription().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(dashboardPage.rankSection().getIcon().isDisplayed());
        log.debug("Check that progress and performance is displayed");
        assertTrue(dashboardPage.rankSection().getProgressAndPerformance().isDisplayed());
        log.debug("Check that progress bar is displayed");
        assertTrue(dashboardPage.rankSection().getProgressBar().isDisplayed());
    }

    void verifySlidingCards() {
        log.warn("Scroll to cards section");
        dashboardPage.scrollToCards();
        log.warn("Fling to Frontline Qualifying Volume");
        dashboardPage.cardSection().scrollToCard("FQV-card");
        log.debug("Check Frontline Qualifying Volume elements");
        checkCard("Frontline Qualifying Volume");
        dashboardPage.cardSection().scrollToCard("G0V-card");
        log.debug("Check Generation 0 Volume elements");
        checkCard("Generation 0 Volume");
        dashboardPage.cardSection().scrollToCard("TGV-card");
        log.debug("Check Total Generation Volume elements");
        checkCard("Total Generation Volume");
    }

    void checkCard(String title) {
        log.debug("Check that {} title is displayed", title);
        assertTrue(dashboardPage.cardSection().getTitle().isDisplayed());
        log.debug("Check that {} title is right", title);
        assertEquals(dashboardPage.cardSection().getTitle().getText(), title);
        log.debug("Check that {} main value is displayed", title);
        assertTrue(dashboardPage.cardSection().getMainValue().isDisplayed());
        log.debug("Check that {} main value is not negative", title);
        assertTrue(Parser.parseNumberWithCommaToDouble(dashboardPage.cardSection().getMainValue().getText()) >= 0);
        log.debug("Check that {} info icon is displayed", title);
        assertTrue(dashboardPage.cardSection().getInfoIcon().isDisplayed());
        log.debug("Check that {} this month title is displayed", title);
        assertTrue(dashboardPage.cardSection().getThisMonthTitle().isDisplayed());
        log.debug("Check that {} this month value is displayed", title);
        assertTrue(dashboardPage.cardSection().getThisMonthValue().isDisplayed());
        log.debug("Check that {} this month value is not negative", title);
        assertTrue(Parser.parseNumberWithCommaToDouble(dashboardPage.cardSection().getThisMonthValue().getText()) >= 0);
        log.debug("Check that {} same time last month title is displayed", title);
        assertTrue(dashboardPage.cardSection().getSameTimeLastMonthTitle().isDisplayed());
        log.debug("Check that {} same time last month value is displayed", title);
        assertTrue(dashboardPage.cardSection().getSameTimeLastMonthValue().isDisplayed());
        log.debug("Check that {} last month title is displayed", title);
        assertTrue(dashboardPage.cardSection().getLastMonthTitle().isDisplayed());
        log.debug("Check that {} last month value is displayed", title);
        assertTrue(dashboardPage.cardSection().getLastMonthValue().isDisplayed());
        log.debug("Check that {} last month value is not negative", title);
        assertTrue(Parser.parseNumberWithCommaToDouble(dashboardPage.cardSection().getLastMonthValue().getText()) >= 0);
    }

    void verifyCoachesSection() {
        log.warn("Scroll to teams section, so that coaches are displayed");
        dashboardPage.scrollToSection(dashboardPage.teamsOverviewSection().getTeamsOverviewDescription());
        log.debug("Check that title is displayed");
        assertTrue(dashboardPage.coachesSection().getTitle().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(dashboardPage.coachesSection().getInfoIcon().isDisplayed());
        log.debug("Check new-frontline line");
        checkCoachesLine("new-frontline");
        log.debug("Check all-frontline line");
        checkCoachesLine("all-frontline");
        log.debug("Check new-generation-0 line");
        checkCoachesLine("new-generation-0");
        log.debug("Check all-generation-0 line");
        checkCoachesLine("all-generation-0");
        log.debug("Check new-organization line");
        checkCoachesLine("new-organization");
        log.debug("Check all-organization line");
        checkCoachesLine("all-organization");
    }

    void checkCoachesLine(String title) {
        log.debug("Check that {} title is displayed", title);
        assertTrue(dashboardPage.coachesSection().getTitle(title).isDisplayed());
        log.debug("Check that {} value is displayed", title);
        assertTrue(dashboardPage.coachesSection().getValue(title).isDisplayed());
        log.debug("Check that {} value is not negative", title);
        assertTrue(Parser.parseNumberWithCommaToDouble(dashboardPage.coachesSection().getValue(title).getText()) >= 0);
    }

    void checkTeamsOverviewLine(String title) {
        log.debug("Check that {} title is displayed", title);
        assertTrue(dashboardPage.teamsOverviewSection().getTitle(title).isDisplayed());
        log.debug("Check that {} value is displayed", title);
        assertTrue(dashboardPage.teamsOverviewSection().getValue(title).isDisplayed());
        log.debug("Check that {} value is not negative", title);
        assertTrue(Parser.parseNumberWithCommaToDouble(dashboardPage.teamsOverviewSection().getValue(title).getText()) >= 0);
    }

    void verifyTeamsOverviewSection() {
        log.warn("Scroll to logo, so that teams section is displayed");
        dashboardPage.scrollToSection(dashboardPage.logoSection().getLogoDescription());
        log.debug("Check that title is displayed");
        assertTrue(dashboardPage.teamsOverviewSection().getTitle().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(dashboardPage.teamsOverviewSection().getInfoIcon().isDisplayed());
        log.debug("Check senior-coach line");
        checkTeamsOverviewLine("senior-coach");
        log.debug("Check executive-director line");
        checkTeamsOverviewLine("executive-director");
        log.debug("Check FIBC line");
        checkTeamsOverviewLine("FIBC");
        log.debug("Check FIBL line");
        checkTeamsOverviewLine("FIBL");
    }
}
