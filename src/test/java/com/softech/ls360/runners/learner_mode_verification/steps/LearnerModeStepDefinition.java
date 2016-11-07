package com.softech.ls360.runners.learner_mode_verification.steps;

import com.softech.ls360.runners.learner_mode_verification.steps.serenity.LearnerModeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by syed.musab on 10/25/2016.
 */
public class LearnerModeStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(LearnerModeStepDefinition.class);

    @Steps
    LearnerModeSteps learnerModeSteps;

    @Given("^user enters learner mode credentials$")
    public void user_enters_learner_mode_credentials() throws Throwable {

       learnerModeSteps.opens_login_page();

    }

    @When("^user navigate to udp homepage$")
    public void user_navigate_to_udp_homepage() throws Throwable {

        learnerModeSteps.openLearnerMode();
    }

    @Then("^user should see \"([^\"]*)\" and \"([^\"]*)\" tab at left panel$")
    public void user_should_see_and_tab_at_left_panel(String learnerTab, String resourceTab) throws Throwable {

        learnerTab = "Learner";
        resourceTab = "Resources";
        logger.info("Then steps" + learnerModeSteps.verifyLearnerTitle());
        logger.info("Then steps" + learnerModeSteps.verifyResourceInLearner());

        assertEquals(learnerModeSteps.verifyLearnerTitle(), learnerTab);
        assertEquals(learnerModeSteps.verifyResourceInLearner(), resourceTab);

        assertTrue(learnerModeSteps.verifySearchButton());
        logger.info("search input is displayed");
    }



}
