package com.softech.ls360.runners.number_of_my_courses.steps;

import com.softech.ls360.runners.mycourses_content_verification.steps.serenity.HomepageContentSteps;
import com.softech.ls360.runners.number_of_my_courses.steps.serenity.NumberOfMyCoursesSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by syed.musab on 11/11/2016.
 */
public class NumberOfMyCoursesStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(NumberOfMyCoursesStepDefinition.class);

    @Steps
    NumberOfMyCoursesSteps numberOfMyCoursesSteps;
    HomepageContentSteps homepageContentSteps;



    @Given("^user navigates to lms signIn page$")
    public void user_navigates_to_lms_signIn_page(){


        logger.info("<---------------------------------------------------->");
        logger.info("<------      Starting LMS Login Test           ------>");
        logger.info("<---------------------------------------------------->");

        numberOfMyCoursesSteps.opens_login_page();


    }

    @When("^user enters in lms homepage$")
    public void user_enters_in_lms_homepage() {

        numberOfMyCoursesSteps.enterUserCredentials();

    }

    @When("^user clicks on continue button from initial screen and navigates to learner mode$")
    public void user_clicks_on_continue_button_from_initial_screen_and_navigates_to_learner_mode() throws Throwable {

        numberOfMyCoursesSteps.clickContinueButton();
        numberOfMyCoursesSteps.selectUserModeFromDropdown();
    }

    @Then("^user access the course from the Available Courses page in the LMS then enrollment is created$")
    public void user_access_the_course_from_the_Available_Courses_page_in_the_LMS_then_enrollment_is_created() throws Throwable {

        numberOfMyCoursesSteps.selectShowAvailableCoursesOption();
        numberOfMyCoursesSteps.clickCourseFromSelectedCourseGroup("MUAT - Activity templates");

    }

    @Then("^verify Number of My Courses count must increased by (\\d+) in the current value$")
    public void verify_Number_of_My_Courses_count_must_increased_by_in_the_current_value(int arg1) throws Throwable {

        numberOfMyCoursesSteps.udp_opens_login_page();
        numberOfMyCoursesSteps.valid_userName_password();
        numberOfMyCoursesSteps.click_signIn_button();
        logger.info("Count All Courses" + numberOfMyCoursesSteps.getLearnerCourseCountAll() + numberOfMyCoursesSteps.courseCountAll());
        assertEquals(numberOfMyCoursesSteps.getLearnerCourseCountAll(), numberOfMyCoursesSteps.courseCountAll());


    }


}
