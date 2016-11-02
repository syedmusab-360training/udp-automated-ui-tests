package com.softech.ls360.runners.udp_webtests.steps;

import com.softech.ls360.runners.udp_webtests.steps.serenity.HomepageSteps;
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
    HomepageSteps homepageSteps;

    @When("^user clicks on New Button from search bar$")
    public void user_clicks_on_New_Button_from_search_bar() {

        logger.info("<---------------------------------------------------->");
        logger.info("<------Starting verify New Courses in UDP   Test ---->");
        logger.info("<---------------------------------------------------->");

       assertTrue(homepageSteps.homepageIsDisplayed());


    }

    @Then("^only new status course should be displayed in that particular branch$")
    public void only_new_status_course_should_be_displayed_in_that_particular_branch() {

        assertEquals(homepageSteps.getLearnerNewStatusInfo(), homepageSteps.verifyNewStatusCourses());

    }

    @When("^user clicks on started button from search bar$")
    public void user_clicks_on_started_button_from_search_bar() {

        assertTrue(homepageSteps.homepageIsDisplayed());
        homepageSteps.clickStartedButton();

    }

    @Then("^only started status courses should be displayed in that particular branch$")
    public void only_started_status_courses_should_be_displayed_in_that_particular_branch() {

        assertThat(homepageSteps.getLearnerStartedStatusInfo(), is(equalToIgnoringCase(homepageSteps.verifyStartedStatusCourses())));

    }

}
