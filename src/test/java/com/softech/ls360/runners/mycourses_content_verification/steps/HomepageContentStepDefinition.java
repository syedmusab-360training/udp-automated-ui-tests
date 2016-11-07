package com.softech.ls360.runners.mycourses_content_verification.steps;

import com.softech.ls360.runners.mycourses_content_verification.steps.serenity.HomepageContentSteps;
import com.softech.ls360.utlis.SeachButton;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class HomepageContentStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(HomepageContentSteps.class);
    private List<SeachButton> searchBarList = new ArrayList<SeachButton>();;

    @Steps
    HomepageContentSteps homepageContentSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() {

        logger.info("<---------------------------------------------------->");
        logger.info("<--    Starting homepage content Login Test        -->");
        logger.info("<---------------------------------------------------->");
        homepageContentSteps.opens_login_page();

    }

    @When("^user enters valid credentials$")
    public void user_enters_valid_credentials() {

        homepageContentSteps.valid_userName_password();
        homepageContentSteps.click_signIn_button();

    }

    @Then("^user should be taken to udp homepage$")
    public void user_should_be_taken_to_udp_homepage() {

        homepageContentSteps.homepageIsDisplayed();
    }


    @Then("^\"([^\"]*)\" should be displayed in first box with respect to all courses count$")
    public void should_be_displayed_in_first_box_with_respect_to_all_courses_count(String numberOfCourses) throws Throwable {

        numberOfCourses = "Number Of My Courses";
        assertEquals(homepageContentSteps.verifyNumberOfCoursesTitle(), numberOfCourses);
        assertEquals(homepageContentSteps.getLearnerCourseCountAll(), homepageContentSteps.courseCountAll());
        logger.info("Count All Courses" + homepageContentSteps.getLearnerCourseCountAll() + homepageContentSteps.courseCountAll());
    }

    @Then("^\"([^\"]*)\" should be displayed in second box with respect to subscription count$")
    public void should_be_displayed_in_second_box_with_respect_to_subscription_count(String subscriptionTitle) throws Throwable {

        logger.info("<---------------------------------------------------->");
        logger.info("<------     courses In Your Subscription         ---->");
        logger.info("<---------------------------------------------------->");

        subscriptionTitle = "Courses In Your Subscription";
        assertEquals(homepageContentSteps.verifySubscriptionTitle(), subscriptionTitle);
        logger.info("Subscription Count is here" + homepageContentSteps.getLearnerCourseCountAll());
        assertEquals(homepageContentSteps.getLearnerSubscriptionCount(), homepageContentSteps.subscriptionCount());
    }

    @Then("^\"([^\"]*)\" should be displayed in third box with respect to completed count$")
    public void should_be_displayed_in_third_box_with_respect_to_completed_count(String completedTitle) throws Throwable{

        completedTitle = "Courses You've Completed";
        assertEquals(homepageContentSteps.verifyCompletedCourseTitle(), completedTitle);
        assertEquals(homepageContentSteps.getLearnerCountCompleted(), homepageContentSteps.completedCount());

    }

    @Then("^verify the page heading is displayed$")
    public void verify_the_page_heading_is_displayed() {

        String pageHeading = "My Courses";
        assertEquals(homepageContentSteps.verify_page_heading(), pageHeading);
    }

    @When("^user enters in udp homepage$")
    public void user_enters_in_udp_homepage() {

        homepageContentSteps.valid_userName_password();
        homepageContentSteps.click_signIn_button();
        homepageContentSteps.homepageIsDisplayed();

    }

    @Then("^Verify that on my courses page should display input field for search courses$")
    public void verify_that_on_my_courses_page_should_display_input_field_for_search_courses() {

        assertTrue(homepageContentSteps.verifySearchButton());
    }

    @Then("^Verify that search bar contains following button$")
    public void verify_that_search_bar_contains_following_button(DataTable dataTable) {

        searchBarList = dataTable.asList(SeachButton.class);
        logger.info("list is here" + searchBarList);
        logger.info("search bar list" + searchBarList.get(0).toString());
        assertEquals(homepageContentSteps.verifySearchButtonAll(), searchBarList.get(0).toString());
        assertEquals(homepageContentSteps.verifySearchButtonNew(), searchBarList.get(1).toString());
        assertEquals(homepageContentSteps.verifySearchButtonStarted(), searchBarList.get(2).toString());
        assertEquals(homepageContentSteps.verifySearchButtonCompleted(), searchBarList.get(3).toString());
        assertEquals(homepageContentSteps.verifySearchButtonSubscription(), searchBarList.get(4).toString());
        assertTrue(homepageContentSteps.verifySortBtn());
    }

}
