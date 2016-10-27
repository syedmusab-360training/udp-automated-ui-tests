package com.softech.ls360.runners.udp_webtests.steps;

import com.softech.ls360.runners.udp_webtests.steps.serenity.HomepageSteps;
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
    HomepageSteps homepageSteps;

    @Given("^user enters learner mode credentials$")
    public void user_enters_learner_mode_credentials() throws Throwable {

        homepageSteps.opens_login_page();

    }

    @When("^user navigate to udp homepage$")
    public void user_navigate_to_udp_homepage() throws Throwable {

        homepageSteps.openLearnerMode();
    }

    @Then("^user should see \"([^\"]*)\" and \"([^\"]*)\" tab at left panel$")
    public void user_should_see_and_tab_at_left_panel(String learnerTab, String resourceTab) throws Throwable {

        learnerTab = "Learner";
        resourceTab = "Resources";
        logger.info("Then step" + homepageSteps.verifyLearnerTitle());
        logger.info("Then step" + homepageSteps.verifyResourceInLearner());

        assertEquals(homepageSteps.verifyLearnerTitle(), learnerTab);
        assertEquals(homepageSteps.verifyResourceInLearner(), resourceTab);

        assertTrue(homepageSteps.verifySearchButton());
        logger.info("search input is displayed");
    }

}
