package com.softech.ls360.runners.course_status_verification.steps;

import com.softech.ls360.runners.course_status_verification.steps.serenity.CourseStatusSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.*;

/**
 * Created by syed.musab on 10/28/2016.
 */
public class CourseStatusStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(CourseStatusStepDefinition.class);

    @Steps
    CourseStatusSteps courseStatusSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() throws Throwable {

        logger.info("<---------------------------------------------------->");
        logger.info("<------      Starting UDP Login Test           ------>");
        logger.info("<---------------------------------------------------->");
        courseStatusSteps.opens_login_page();
    }


    @When("^user enters in udp homepage$")
    public void user_enters_in_udp_homepage() throws Throwable {

        courseStatusSteps.valid_userName_password();
        courseStatusSteps.click_signIn_button();
        courseStatusSteps.homepageIsDisplayed();
    }

    @When("^user clicks on New Button from search bar$")
    public void user_clicks_on_New_Button_from_search_bar() {

        logger.info("<---------------------------------------------------->");
        logger.info("<------Starting verify New Courses in UDP   Test ---->");
        logger.info("<---------------------------------------------------->");
       assertTrue(courseStatusSteps.homepageIsDisplayed());
    }

    @Then("^only new status course should be displayed in that particular branch$")
    public void only_new_status_course_should_be_displayed_in_that_particular_branch() {

     //  assertEquals(courseStatusSteps.getLearnerNewStatusInfo(), courseStatusSteps.verifyNewStatusCourses());

    }

    @When("^user clicks on started button from search bar$")
    public void user_clicks_on_started_button_from_search_bar() {

        assertTrue(courseStatusSteps.homepageIsDisplayed());
        courseStatusSteps.clickStartedButton();

    }

    @Then("^only started status courses should be displayed in that particular branch$")
    public void only_started_status_courses_should_be_displayed_in_that_particular_branch() {

        assertThat(courseStatusSteps.getLearnerStartedStatusInfo(), is(equalToIgnoringCase(courseStatusSteps.verifyStartedStatusCourses())));

    }
    @When("^user clicks on completed button from search bar$")
    public void user_clicks_on_completed_button_from_search_bar() {

        assertTrue(courseStatusSteps.homepageIsDisplayed());
        courseStatusSteps.clickCompletedButton();

    }

    @Then("^only completed type courses should be displayed in that particular branch$")
    public void only_completed_type_courses_should_be_displayed_in_that_particular_branch() {

        assertThat(courseStatusSteps.getLearnerCompletedStatusInfo(), is(equalToIgnoringCase(courseStatusSteps.verifyCompletedTypeCourses())));

    }

}
