package com.softech.ls360.runners.isotope_content_verification.steps;

import com.softech.ls360.runners.isotope_content_verification.steps.serenity.CourseIsotopeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class CourseIsotopeStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(CourseIsotopeStepDefinition.class);

    @Steps
    CourseIsotopeStep courseIsotopeStep;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() {

        logger.info("<---------------------------------------------------->");
        logger.info("<--    Starting course Isotope Login Test          -->");
        logger.info("<---------------------------------------------------->");
        courseIsotopeStep.opens_login_page();
    }

    @When("^user enters in udp homepage$")
    public void user_enters_in_udp_homepage() {

        courseIsotopeStep.valid_userName_password();
        courseIsotopeStep.click_signIn_button();
        courseIsotopeStep.homepageIsDisplayed();

    }

    @When("^user clicks on retake this course icon or course isotope image\\.$")
    public void user_clicks_on_retake_this_course_icon_or_course_isotope_image() throws InterruptedException {


    }

    @Then("^it should popup \"([^\"]*)\" window$")
    public void it_should_popup_window(String actualWindowHandle) {

        courseIsotopeStep.clickRekateCourseBtn(actualWindowHandle);
    }
}
