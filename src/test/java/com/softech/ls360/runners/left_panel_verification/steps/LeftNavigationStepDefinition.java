package com.softech.ls360.runners.left_panel_verification.steps;

import com.softech.ls360.runners.left_panel_verification.steps.serenity.LeftNavigationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class LeftNavigationStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(LeftNavigationStepDefinition.class);

    @Steps
    LeftNavigationSteps leftNavigationSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() {

        logger.info("<---------------------------------------------------->");
        logger.info("<--    Starting LeftNavigation Login Test          -->");
        logger.info("<---------------------------------------------------->");
        leftNavigationSteps.opens_login_page();

    }

    @When("^user enters in udp homepage$")
    public void user_enters_in_udp_homepage() {

        leftNavigationSteps.valid_userName_password();
        leftNavigationSteps.click_signIn_button();
        leftNavigationSteps.homepageIsDisplayed();

    }

    @Then("^Verify that on Dashboard page left panel, main heading should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_main_heading_should_be(String dashboardTitle) {

        dashboardTitle = "Dashboard";
        assertEquals(leftNavigationSteps.verifyDashboardTitle(), dashboardTitle);
    }

    @Then("^Verify that on Dashboard page left panel, first submenu should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_first_submenu_should_be(String authorSubheading) {

        authorSubheading = "Author";
        logger.info("text values" + leftNavigationSteps.verifyAuthorTitle());
        assertEquals(leftNavigationSteps.verifyAuthorTitle(), authorSubheading);
    }

    @Then("^Verify under author menu, first tab is \"([^\"]*)\"$")
    public void verify_under_author_menu_first_tab_is(String courseReport) {

        courseReport = "Course Reports";
        assertEquals(leftNavigationSteps.verifyCourseReportTextfromLeftPanel(), courseReport);
    }

    @Then("^Verify under author menu, second tab \"([^\"]*)\"$")
    public void verify_under_author_menu_second_tab(String createManageCourses) {

        createManageCourses = "Create & Manage Courses";
        assertEquals(leftNavigationSteps.verifyCreateManageTextFromLeftPanel(), createManageCourses);

    }

    @Then("^Verify that first tab is \"([^\"]*)\"$")
    public void verify_that_first_tab_is(String myCoursesTab){

        myCoursesTab = "My Courses";
        assertEquals(leftNavigationSteps.verifyMycoursesfromLeftPanel(), myCoursesTab);

    }

    @Then("^Verify that on Dashboard page left panel, second submenu should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_second_submenu_should_be(String authorSubheading) {

        authorSubheading = "Author";
        assertEquals(leftNavigationSteps.verifyAuthorTitle(), authorSubheading);
    }


    @Then("^Verify that second tab is \"([^\"]*)\"$")
    public void verify_that_second_tab_is(String mySubscription) {

        mySubscription = "My Subscriptions";
        assertEquals(leftNavigationSteps.verifyMySubscriptionfromLeftPanel(), mySubscription);
    }

    @Then("^Verify that third tab is \"([^\"]*)\"$")
    public void verify_that_third_tab_is(String transCert) {
        transCert = "Transcripts & Certificates";
        assertEquals(leftNavigationSteps.verifyTransCertFromLeftPanel(), transCert);
    }

    @Then("^Verify that on Dashboard page left panel, third tab should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_third_tab_should_be(String managerText) {

        managerText = "Manager";
        assertEquals(leftNavigationSteps.verifyManagerTab(), managerText);
    }


    @Then("^Verify under manager menu, first tab is \"([^\"]*)\"$")
    public void verify_under_manager_menu_first_tab_is(String managerUser) {
        managerUser = "Manage Users";
        assertEquals(leftNavigationSteps.verifyManageUserTextFromLeftPanel(), managerUser);
    }


    @Then("^Verify under manager menu, second tab is \"([^\"]*)\"$")
    public void verify_under_manager_menu_second_tab_is(String enrollUser) {

        enrollUser = "Enroll Users";
        assertEquals(leftNavigationSteps.verifyEnrollUserTextFromLeftPanel(), enrollUser);

    }

    @Then("^Verify under manager menu, third tab is \"([^\"]*)\"$")
    public void verify_under_manager_menu_third_tab_is(String runReport)  {

        runReport = "Run Reports";
        assertEquals(leftNavigationSteps.verifyRunReportsTextFromLeftPanel(), runReport);
    }

    @Then("^Verify that on Dashboard page left panel, fourth tab should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_fourth_tab_should_be(String resourceText) {
        resourceText = "Resources";
        assertEquals(leftNavigationSteps.verifyResourceText(), resourceText);

    }

    @Then("^Verify under resource menu, first tab is \"([^\"]*)\"$")
    public void verify_under_resource_menu_first_tab_is(String shopCoursesText) {
        shopCoursesText = "Shop Courses";
        assertEquals(leftNavigationSteps.verifyShopCourses(), shopCoursesText);

    }

    @Then("^Verify under resource menu, second tab is \"([^\"]*)\"$")
    public void verify_under_resource_menu_second_tab_is(String browseFreeCourses) {
        browseFreeCourses = "Browse Free Courses";
        assertEquals(leftNavigationSteps.verifyBrowserCourses(), browseFreeCourses);
    }

    @Then("^Verify under resource menu, third tab is \"([^\"]*)\"$")
    public void verify_under_resource_menu_third_tab_is(String supportForum) {
        supportForum = "Support Forum";
        assertEquals(leftNavigationSteps.verifySupportForum(), supportForum);

    }

    @Then("^Verify that on Dashboard page left panel, third submenu should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_third_submenu_should_be(String managerSubheading) {

        managerSubheading = "Manager";
        assertEquals(leftNavigationSteps.verifyManagerTitle(), managerSubheading);

    }

    @Then("^Verify that on Dashboard page left panel, fourth submenu should be \"([^\"]*)\"$")
    public void verify_that_on_Dashboard_page_left_panel_fourth_submenu_should_be(String resourcesSubheading) {

        resourcesSubheading = "Resources";
        assertEquals(leftNavigationSteps.verifyResourcesTitle(), resourcesSubheading);
    }

    @When("^Verify that when user clicks on Manager User button$")
    public void verify_that_when_user_clicks_on_Manager_User_button() {

        leftNavigationSteps.homepageIsDisplayed();
        leftNavigationSteps.clickManagerUser();

    }

    @Then("^it should be redirected to LMS Manager Mode screen manage users and Groups page$")
    public void it_should_be_redirected_to_LMS_Manager_Mode_screen_manage_users_and_Groups_page() {

        assertEquals(leftNavigationSteps.managerModeWindowIsDisplayed(), "Manage Users");
        logger.info("Manager Mode is displayed");
    }

    @When("^Verify that when user clicks on Create and Manage Courses button$")
    public void verify_that_when_user_clicks_on_Create_and_Manage_Courses_button() {

        leftNavigationSteps.homepageIsDisplayed();
        leftNavigationSteps.clickCreateManager();

    }

    @Then("^it should be redirected to WLCMS Author Mode screen create courses page$")
    public void it_should_be_redirected_to_WLCMS_Author_Mode_screen_create_courses_page() {
        assertEquals(leftNavigationSteps.redirectedToWlcmsAuthor(), "Author, Teach, and Sell");
        logger.info("Author Mode is displayed");

    }

    @When("^Verify that when user clicks on Enroll Users button$")
    public void verify_that_when_user_clicks_on_Enroll_Users_button() {

        leftNavigationSteps.homepageIsDisplayed();
        leftNavigationSteps.clickEnrollUser();

    }

    @Then("^it should be redirected to LMS Manager Mode plan and enroll page\\.$")
    public void it_should_be_redirected_to_LMS_Manager_Mode_plan_and_enroll_page() {

        assertEquals(leftNavigationSteps.redirectedToEnrollUserPage(), "Enroll");
        logger.info("Enroll Mode is displayed");

    }

    @When("^Verify that when user clicks on Run Reports button$")
    public void verify_that_when_user_clicks_on_Run_Reports_button() {

        leftNavigationSteps.homepageIsDisplayed();
        leftNavigationSteps.clickRunReport();

    }

    @Then("^it should be redirected to LMS Manager Mode, Report Summary Page$")
    public void it_should_be_redirected_to_LMS_Manager_Mode_Report_Summary_Page() {

        assertEquals(leftNavigationSteps.redirectedToLMSRunSummaryScreen(), "Report Summary");
        logger.info("Report Summary Mode is displayed");
    }
}
