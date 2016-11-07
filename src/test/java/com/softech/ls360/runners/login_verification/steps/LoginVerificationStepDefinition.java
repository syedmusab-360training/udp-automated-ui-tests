package com.softech.ls360.runners.login_verification.steps;

import com.softech.ls360.runners.login_verification.steps.Serenity.LoginVerificationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertEquals;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class LoginVerificationStepDefinition extends ScenarioSteps {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoginVerificationStepDefinition.class);

    @Steps
    LoginVerificationSteps loginVerificationSteps;

    @Given("^user navigates to signIn page$")
    public void user_navigates_to_signIn_page() throws Throwable {

        logger.info("<---------------------------------------------------->");
        logger.info("<------      Starting UDP Login Test           ------>");
        logger.info("<---------------------------------------------------->");

        loginVerificationSteps.opens_login_page();

    }

    @When("^user enters valid credentials$")
    public void user_enters_valid_credentials() throws Throwable {

        loginVerificationSteps.valid_userName_password();

    }

    @Then("^user should be taken to udp homepage$")
    public void user_should_be_taken_to_udp_homepage()  {

        loginVerificationSteps.click_signIn_button();
    }

    @Then("^click on dropdown button and select signout$")
    public void click_on_dropdown_button_and_select_signout() throws Throwable {

        loginVerificationSteps.homepageProfileDropdown();
        loginVerificationSteps.click_profile_signout_button();

    }

    @When("^user enters invalid credentials$")
    public void user_enters_invalid_credentials() throws Throwable {

        loginVerificationSteps.invalid_userName_Password();
        loginVerificationSteps.click_signIn_button();
    }

    @Then("^user should get an appropriate error message$")
    public void user_should_get_an_appropriate_error_message() throws Throwable {

        String error_text;

        error_text = "Invalid User Name or Password. Please try again.";
        assertEquals(error_text, loginVerificationSteps.get_Error_Message0());

    }


}
