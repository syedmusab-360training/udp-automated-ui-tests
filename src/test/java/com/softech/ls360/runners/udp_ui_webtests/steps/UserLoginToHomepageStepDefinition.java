package com.softech.ls360.runners.udp_ui_webtests.steps;

import com.softech.ls360.runners.udp_ui_webtests.steps.serenity.UserLoginToHomepageSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by syed.musab on 10/14/2016.
 */
public class UserLoginToHomepageStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginToHomepageSteps.class);

    String error_text;

    @Steps
    UserLoginToHomepageSteps userLoginToHomepageSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() throws Throwable {

    userLoginToHomepageSteps.opens_login_page();

    }

    @When("^user enters valid credentials$")
    public void user_enters_valid_credentials() throws Throwable {

        userLoginToHomepageSteps.valid_userName_password();

    }

    @Then("^user should be taken to udp homepage$")
    public void user_should_be_taken_to_udp_homepage() throws Throwable {

        userLoginToHomepageSteps.click_signIn_button();
    }

    @Then("^click on dropdown button and select signout$")
    public void click_on_dropdown_button_and_select_signout() throws Throwable {

        userLoginToHomepageSteps.homepageProfileDropdown();
        userLoginToHomepageSteps.click_profile_signout_button();

    }

    @When("^user enters invalid credentials$")
    public void user_enters_invalid_credentials() throws Throwable {

        userLoginToHomepageSteps.invalid_userName_Password();
        userLoginToHomepageSteps.click_signIn_button();
    }

    @Then("^user should get an appropriate error message$")
    public void user_should_get_an_appropriate_error_message() throws Throwable {

       error_text = "Invalid User Name or Password. Please try again.";
       assertEquals(error_text, userLoginToHomepageSteps.get_Error_Message0());

    }

    @Then("^verify the page heading is displayed$")
    public void verify_the_page_heading_is_displayed() throws Throwable {

        String pageHeading = "My Courses";
        assertEquals(userLoginToHomepageSteps.verify_page_heading(), pageHeading);
    }

    @When("^user enters in udp homepage$")
    public void user_enters_in_udp_homepage() throws Throwable {

        userLoginToHomepageSteps.valid_userName_password();
        userLoginToHomepageSteps.click_signIn_button();
        userLoginToHomepageSteps.homepageIsDisplayed();

    }

    @Then("^\"([^\"]*)\" should be displayed in first box$")
    public void should_be_displayed_in_first_box(String numberOfCourses) throws Throwable {

        numberOfCourses = "Number Of My Courses";
        assertEquals(userLoginToHomepageSteps.verifyNumberOfCoursesTitle(), numberOfCourses);
    }

    @Then("^\"([^\"]*)\" should be displayed in second box with respect to subscription count$")
    public void should_be_displayed_in_second_box_with_respect_to_subscription_count(String subscriptionTitle) throws Throwable {

        subscriptionTitle = "Courses In Your Subscription";
        assertEquals(userLoginToHomepageSteps.verifySubscriptionTitle(), subscriptionTitle);
       logger.info("Subscription Count is here" + userLoginToHomepageSteps.getLearnerSubscriptionCount());
        assertEquals(userLoginToHomepageSteps.getLearnerSubscriptionCount(), userLoginToHomepageSteps.subscriptionCount());
    }


    @Then("^\"([^\"]*)\" should be displayed in third box with respect to completed count$")
    public void should_be_displayed_in_third_box_with_respect_to_completed_count(String completedTitle) throws Throwable{

        completedTitle = "Courses You've Completed";
        assertEquals(userLoginToHomepageSteps.verifyCompletedCourseTitle(), completedTitle);
        assertEquals(userLoginToHomepageSteps.getLearnerCountCompleted(), userLoginToHomepageSteps.completedCount());


    }

}
