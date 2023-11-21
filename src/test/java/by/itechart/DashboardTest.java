package by.itechart;

import by.itechart.pages.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DashboardTest extends BaseTest {
    DashboardPage dashboardPage;
    CardPage cardPage;
    CoachesPage coachesPage;
    TeamsOverviewPage teamsOverviewPage;

    @Test
    public void testDashboard() {
        log.info("Start Dashboard test");
        log.info("Login with valid credentials");
        login();
        dashboardPage = new DashboardPage(driver);
        log.debug("Wait for page loading");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.getFqvCardLocator()));
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
        assertTrue(dashboardPage.getRankSection().isDisplayed());
        log.debug("Check that Frontline Qualifying Volume card is displayed");
        assertTrue(dashboardPage.getFqvCard().isDisplayed());
        log.warn("Fling to card Generation 0 Volume");
        dashboardPage.flingToCard("Generation 0 Volume");
        log.debug("Check that card Generation 0 Volume is displayed");
        assertTrue(dashboardPage.getG0vCard().isDisplayed());
        log.warn("Fling to card Total Generation Volume");
        dashboardPage.flingToCard("Total Generation Volume");
        log.debug("Check that Total Generation Volume card is displayed");
        assertTrue(dashboardPage.getTgvCard().isDisplayed());
        log.debug("Check that coaches section is displayed");
        assertTrue(dashboardPage.getCoachesSection().isDisplayed());
        log.warn("Scroll to teams overview");
        WebElement teamsOverview = dashboardPage.scrollToSection(dashboardPage.getTeamsOverviewDescription());
        log.debug("Check that teams overview section is displayed");
        assertTrue(teamsOverview.isDisplayed());
        log.warn("Scroll to logo");
        WebElement logo = dashboardPage.scrollToSection(dashboardPage.getLogoDescription());
        log.debug("Check that logo is displayed");
        assertTrue(logo.isDisplayed());
    }

    void verifyRankProgressCard() {
        log.warn("Scroll to rank progress section");
        dashboardPage.scrollToSection(dashboardPage.getRankProgressCardDescription());
        RankPage rankPage = new RankPage(driver);
        log.debug("Check that title is displayed");
        assertTrue(rankPage.getTitle().isDisplayed());
        log.debug("Check that description is displayed");
        assertTrue(rankPage.getDescription().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(rankPage.getIcon().isDisplayed());
        log.debug("Check that progress and performance is displayed");
        assertTrue(rankPage.getProgressAndPerformance().isDisplayed());
        log.debug("Check that progress bar is displayed");
        assertTrue(rankPage.getProgressBar().isDisplayed());
    }

    void verifySlidingCards() {
        log.warn("Scroll to cards section");
        dashboardPage.scrollToCards();
        log.warn("Fling to Frontline Qualifying Volume");
        dashboardPage.flingToCard("Frontline Qualifying Volume");
        cardPage = new CardPage(driver);
        log.debug("Check Frontline Qualifying Volume elements");
        checkCard("Frontline Qualifying Volume");
        dashboardPage.flingToCard("Generation 0 Volume");
        log.debug("Check Generation 0 Volume elements");
        checkCard("Generation 0 Volume");
        dashboardPage.flingToCard("Total Generation Volume");
        log.debug("Check Total Generation Volume elements");
        checkCard("Total Generation Volume");
    }

    void checkCard(String title) {
        log.debug("Check that {} title is displayed", title);
        assertTrue(cardPage.getTitle().isDisplayed());
        log.debug("Check that {} title is right", title);
        assertEquals(cardPage.getTitle().getText(), title);
        log.debug("Check that {} main value is displayed", title);
        assertTrue(cardPage.getMainValue().isDisplayed());
        log.debug("Check that {} main value is not negative", title);
        assertTrue(Double.parseDouble(cardPage.getMainValue().getText().replaceAll(",", ".")) >= 0);
        log.debug("Check that {} info icon is displayed", title);
        assertTrue(cardPage.getInfoIcon().isDisplayed());
        log.debug("Check that {} this month title is displayed", title);
        assertTrue(cardPage.getThisMonthTitle().isDisplayed());
        log.debug("Check that {} this month value is displayed", title);
        assertTrue(cardPage.getThisMonthValue().isDisplayed());
        log.debug("Check that {} this month value is not negative", title);
        assertTrue(Double.parseDouble(cardPage.getThisMonthValue().getText().replaceAll(",", ".")) >= 0);
        log.debug("Check that {} same time last month title is displayed", title);
        assertTrue(cardPage.getSameTimeLastMonthTitle().isDisplayed());
        log.debug("Check that {} same time last month value is displayed", title);
        assertTrue(cardPage.getSameTimeLastMonthValue().isDisplayed());
        log.debug("Check that {} last month title is displayed", title);
        assertTrue(cardPage.getLastMonthTitle().isDisplayed());
        log.debug("Check that {} last month value is displayed", title);
        assertTrue(cardPage.getLastMonthValue().isDisplayed());
        log.debug("Check that {} last month value is not negative", title);
        assertTrue(Double.parseDouble(cardPage.getLastMonthValue().getText().replaceAll(",", ".")) >= 0);
    }

    void verifyCoachesSection() {
        coachesPage = new CoachesPage(driver);
        log.warn("Scroll to teams section, so that coaches are displayed");
        dashboardPage.scrollToSection(dashboardPage.getTeamsOverviewDescription());
        log.debug("Check that title is displayed");
        assertTrue(coachesPage.getTitle().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(coachesPage.getInfoIcon().isDisplayed());
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
        assertTrue(coachesPage.getTitle(title).isDisplayed());
        log.debug("Check that {} value is displayed", title);
        assertTrue(coachesPage.getValue(title).isDisplayed());
        log.debug("Check that {} value is not negative", title);
        assertTrue(Double.parseDouble(coachesPage.getValue(title).getText().replaceAll(",", ".")) >= 0);
    }

    void checkTeamsOverviewLine(String title) {
        log.debug("Check that {} title is displayed", title);
        assertTrue(teamsOverviewPage.getTitle(title).isDisplayed());
        log.debug("Check that {} value is displayed", title);
        assertTrue(teamsOverviewPage.getValue(title).isDisplayed());
        log.debug("Check that {} value is not negative", title);
        assertTrue(Double.parseDouble(teamsOverviewPage.getValue(title).getText().replaceAll(",", ".")) >= 0);
    }

    void verifyTeamsOverviewSection() {
        teamsOverviewPage = new TeamsOverviewPage(driver);
        log.warn("Scroll to logo, so that teams section is displayed");
        dashboardPage.scrollToSection(dashboardPage.getLogoDescription());
        log.debug("Check that title is displayed");
        assertTrue(teamsOverviewPage.getTitle().isDisplayed());
        log.debug("Check that info icon is displayed");
        assertTrue(teamsOverviewPage.getInfoIcon().isDisplayed());
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
