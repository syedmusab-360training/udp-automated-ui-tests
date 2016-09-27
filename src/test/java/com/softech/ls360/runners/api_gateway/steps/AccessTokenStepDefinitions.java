package com.softech.ls360.runners.api_gateway.steps;

import com.github.javafaker.Faker;
import com.jayway.restassured.response.Response;
import com.softech.ls360.runners.api_gateway.steps.serenity.AccessTokenSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zuhair.mukry on 9/26/2016.
 */
public class AccessTokenStepDefinitions extends ScenarioSteps {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenStepDefinitions.class);

    @Steps
    private AccessTokenSteps accessTokenSteps;

    private String accessTokenEndpoint;
    private String basicAuthUserName;
    private String basicAuthPassword;
    Response responseAccessToken;

    @Given("^get access token through ls360 api gateway$")
    public void getAccessTokenThroughLs360ApiGateway() {
        accessTokenEndpoint = accessTokenSteps.getEndPointUrlForAccessTokenPostRequest();
        assertNotNull(accessTokenEndpoint);
    }

    @When("^a request is sent to ls360 api gateway with valid parameters$")
    public void aRequestIsSentToLs360ApiGatewayWithValidParameters() {

        basicAuthUserName = accessTokenSteps.getBasicAuthUserNameParameterForAccessTokenRequest();
        assertNotNull(basicAuthUserName);

        basicAuthPassword = accessTokenSteps.getBasicAuthPasswordParameterForAccessTokenRequest();
        assertNotNull(basicAuthPassword);

        responseAccessToken = accessTokenSteps
                .requestAccessTokenFromLs360Gateway(accessTokenEndpoint, basicAuthUserName, basicAuthPassword);
    }

    @Then("^ls360 api gateway returns valid access token when valid parameters were passed$")
    public void ls360ApiGatewayShouldReturnValidAccessToken() {
        assertEquals(200, responseAccessToken.getStatusCode());
    }

    @When("^a request is sent to ls360 api gateway with invalid parameters$")
    public void aRequestIsSentToLsApiGatewayWithInvalidParameters() {
        Faker faker = new Faker();

        responseAccessToken = accessTokenSteps
                .requestAccessTokenFromLs360Gateway(accessTokenEndpoint,
                                                faker.bothify("??##??##??##??"),
                                                faker.bothify("??##??##??##??"));
    }

    @Then("^ls360 api gateway returns error with status code (\\d+)$")
    public void lsApiGatewayReturnsErrorWithStatusCode(int statusCode) {
        assertEquals(statusCode, responseAccessToken.getStatusCode());
    }
}
