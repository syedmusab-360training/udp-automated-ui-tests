package com.softech.ls360.runners.udp_webtests.steps;

import com.softech.ls360.runners.udp_webtests.steps.serenity.UserLoginToHomepageSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by syed.musab on 10/25/2016.
 */
public class LearnerMode {
    private static final Logger logger = LoggerFactory.getLogger(LearnerMode.class);

    @Steps
    UserLoginToHomepageSteps userLoginToHomepageSteps;

    @Given("^user enters learner mode credentials$")
    public void user_enters_learner_mode_credentials() throws Throwable {

        userLoginToHomepageSteps.opens_login_page();

    }

    @When("^user navigate to udp homepage$")
    public void user_navigate_to_udp_homepage() throws Throwable {

        userLoginToHomepageSteps.openLearnerMode();
    }

    @Then("^user should see \"([^\"]*)\" and \"([^\"]*)\" tab at left panel$")
    public void user_should_see_and_tab_at_left_panel(String learnerTab, String resourceTab) throws Throwable {

        learnerTab = "Learner";
        resourceTab = "Resources";
        logger.info("Then step" + userLoginToHomepageSteps.verifyLearnerTitle());
        logger.info("Then step" + userLoginToHomepageSteps.verifyResourceInLearner());

        assertEquals(userLoginToHomepageSteps.verifyLearnerTitle(), learnerTab);
        assertEquals(userLoginToHomepageSteps.verifyResourceInLearner(), resourceTab);
    }

}
