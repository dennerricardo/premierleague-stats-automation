package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import pages.DashboardPage;
import qa.DriverFactory;

public class DashboardSteps {

    private DashboardPage dashboardPage = new DashboardPage(DriverFactory.tlDriver.get()); ;

    @Given("user navigates to the Premier League stats page")
    public void user_navigates_to_the_premier_league_stats_page() {
        dashboardPage.getCurrentUrl();

    }

    @And("user validates dashboard page title")
    public void user_validates_dashboard_page_title() {
        System.out.println(dashboardPage.getTitle());
        Assert.assertTrue(dashboardPage.getTitle().equals("Premier League Player Stats & Club Statistics"));
    }

    @When("the statistics dashboard is displayed")
    public void theStatisticsDashboardIsDisplayed() {
        Assert.assertTrue(dashboardPage.theStatisticsDashboardIsDisplayed());

    }

    @Then("the dashboard should show the Goals category")
    public void theDashboardShouldShowTheGoalsCategory() {
        Assert.assertTrue(dashboardPage.theDashboardShouldShowTheGoalsCategory());


    }

    @And("the dashboard should show the Assists category")
    public void theDashboardShouldShowTheAssistsCategory() {
        Assert.assertTrue(dashboardPage.theDashboardShouldShowTheAssistsCategory());

    }

    @And("the dashboard should show the Total Passes category")
    public void theDashboardShouldShowTheTotalPassesCategory() {
        Assert.assertTrue(dashboardPage.theDashboardShouldShowTheTotalPassesCategory());


    }

    @And("the dashboard should show the Clean Sheets category")
    public void theDashboardShouldShowTheCleanSheetsCategory() {
        Assert.assertTrue(dashboardPage.theDashboardShouldShowTheCleanSheetsCategory());
    }
//
//    @Then("a list of goals should be displayed")
//    public void aListOfGoalsShouldBeDisplayed() {
//
//    }
//
//    @Then("a list of assists should be displayed")
//    public void aListOfAssistsShouldBeDisplayed() {
//    }
//
//    @Then("a list of total passes should be displayed")
//    public void aListOfTotalPassesShouldBeDisplayed() {
//
//    }
//
//    @Then("a list of clean sheets should be displayed")
//    public void aListOfCleanSheetsShouldBeDisplayed() {
//    }
}
