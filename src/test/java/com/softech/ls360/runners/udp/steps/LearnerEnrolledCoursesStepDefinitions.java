package com.softech.ls360.runners.udp.steps;

import com.jayway.restassured.response.Response;
import com.softech.ls360.runners.api_gateway.steps.serenity.AccessTokenSteps;
import com.softech.ls360.runners.udp.steps.serenity.LearnerEnrolledCoursesSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zuhair.mukry on 9/26/2016.
 */
public class LearnerEnrolledCoursesStepDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(LearnerEnrolledCoursesStepDefinitions.class);
    private static final int SUCCESS_200 = 200;

    @Steps
    private AccessTokenSteps accessTokenSteps;

    @Steps
    private LearnerEnrolledCoursesSteps learnerEnrolledCoursesSteps;

    private String accessTokenType;
    private String accessTokenFromGatewayApi;

    private Response responseEnrolledCoursesInformation;
    private Response responseEnrolledCoursesCount;

    @Given("^get access token from api gate way to get enrolled courses (?:information|count) for specific learner$")
    public void getAccessTokenFromApiGateWayToGetEnrolledCoursesInformationForSpecificLearner() {
        String accessTokenEndpoint;
        String basicAuthUserName;
        String basicAuthPassword;
        Response responseAccessToken;

        accessTokenEndpoint = accessTokenSteps.getEndPointUrlForAccessTokenPostRequest();
        assertNotNull(accessTokenEndpoint);

        basicAuthUserName = accessTokenSteps.getBasicAuthUserNameParameterForAccessTokenRequest();
        assertNotNull(basicAuthUserName);

        basicAuthPassword = accessTokenSteps.getBasicAuthPasswordParameterForAccessTokenRequest();
        assertNotNull(basicAuthPassword);

        responseAccessToken = accessTokenSteps
                .requestAccessTokenFromLs360Gateway(accessTokenEndpoint, basicAuthUserName, basicAuthPassword);
        assertEquals(SUCCESS_200, responseAccessToken.getStatusCode());

        accessTokenFromGatewayApi = responseAccessToken.path("access_token");
        logger.info("Access Token: \"" + accessTokenFromGatewayApi + "\"");

        accessTokenType = responseAccessToken.path("token_type");
        logger.info("Token type: \"" + accessTokenType + "\"");

        logger.info(accessTokenType + " " + accessTokenFromGatewayApi);
    }

    @When("^enrolled courses information api is called  with valid parameters to get learner enrolled courses information$")
    public void udpLearnerEnrolledCoursesApiIsCalledToGetEnrolledCoursesInformation() {

        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;
        String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
        String enrolledCoursesRequestParameters = learnerEnrolledCoursesSteps.getEnrolledCoursesRequestParameters();
        String learnerEnrolledCoursesInformationEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesEndpoint();

        responseEnrolledCoursesInformation = learnerEnrolledCoursesSteps
                .getLearnerEnrolledCoursesInformation(tokenToBeSentInHeader, authorizationType,
                        enrolledCoursesRequestParameters, learnerEnrolledCoursesInformationEndPoint);
    }

    @Then("^enrolled courses information for provided learner is returned$")
    public void enrolledCoursesInformationForProvidedLearnerIsReturned() {
        assertEquals(SUCCESS_200, responseEnrolledCoursesInformation.getStatusCode());
    }

    @When("^enrolled courses count api is called with valid parameters to get learner enrolled courses count$")
    public void enrolledCoursesCountApiIsCalledWithValidParametersToGetLearnerEnrolledCoursesCount() {
        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;

        String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
        String courseCountRequestParameters = learnerEnrolledCoursesSteps.getCoursesCountRequestParameters();
        String learnerEnrolledCoursesCountEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesCountEndpoint();


        responseEnrolledCoursesCount = learnerEnrolledCoursesSteps
                .getLearnerEnrolledCoursesCount(tokenToBeSentInHeader, authorizationType,
                        courseCountRequestParameters, learnerEnrolledCoursesCountEndPoint);
    }

    @Then("^api call should return learner course count for provided learner$")
    public void apiCallShouldReturnLearnerCourseCountForProvidedLearner() {
        assertEquals(SUCCESS_200, responseEnrolledCoursesCount.getStatusCode());
    }
}
