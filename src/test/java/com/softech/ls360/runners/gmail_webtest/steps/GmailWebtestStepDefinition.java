package com.softech.ls360.runners.gmail_webtest.steps;

import com.softech.ls360.runners.gmail_webtest.steps.serenity.GmailTestSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by syed.musab on 11/28/2016.
 */
public class GmailWebtestStepDefinition {

    GmailTestSteps gmailTestSteps;

    @Given("^user navigates to gmail page$")
    public void user_navigates_to_gmail_page() {

        gmailTestSteps.openGmail();


    }

    @When("^user enters in gmail credentials$")
    public void user_enters_in_gmail_credentials(){

    }

    @Then("^it should display inbox page$")
    public void it_should_display_inbox_page(){

    }

}
