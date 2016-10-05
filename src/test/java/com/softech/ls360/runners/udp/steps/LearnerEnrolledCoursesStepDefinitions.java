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

    private int learnerInProgress = 0;
    private int learnerCompleted = 0;
    private int learnerSubscription = 0;
    private int learnerNotstarted = 0;

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

    @When("^enrolled courses count api is called with parameters \"([^\"]*)\" to get learner enrolled courses count$")
    public void enrolled_courses_count_api_is_called_with_parameters_to_get_learner_enrolled_courses_count(String notstarted) throws Throwable {

        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;

            String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
            String courseCountRequestParameters = (learnerEnrolledCoursesSteps.getCoursesCountRequestPara() + "\"notstarted\"" + "]}");
            String learnerEnrolledCoursesCountEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesCountEndpoint();

            responseEnrolledCoursesCount = learnerEnrolledCoursesSteps
                    .getLearnerEnrolledCoursesCount(tokenToBeSentInHeader, authorizationType,
                            courseCountRequestParameters, learnerEnrolledCoursesCountEndPoint);

      learnerNotstarted = responseEnrolledCoursesCount.path("notstarted");
        logger.info("<----------NotStarted Count Is Here------------>" + learnerNotstarted);

    }
    @When("^enrolled courses count api is called with parameters \"([^\"]*)\", \"([^\"]*)\" to get learner enrolled courses count$")
    public void enrolled_courses_count_api_is_called_with_parameters_to_get_learner_enrolled_courses_count(String notstarted, String subscription) throws Throwable {

        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;
        String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
        String courseCountRequestParameters = (learnerEnrolledCoursesSteps.getCoursesCountRequestPara() + "\"notstarted\"" + "," + "\"subscription\"" + "]}");
        String learnerEnrolledCoursesCountEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesCountEndpoint();

        responseEnrolledCoursesCount = learnerEnrolledCoursesSteps
                .getLearnerEnrolledCoursesCount(tokenToBeSentInHeader, authorizationType,
                        courseCountRequestParameters, learnerEnrolledCoursesCountEndPoint);

        learnerNotstarted = responseEnrolledCoursesCount.path("notstarted");
        logger.info("<----------NotStarted Count Is Here------------>" + learnerNotstarted);

        learnerSubscription = responseEnrolledCoursesCount.path("subscription");
        logger.info("<----------Subscription Count Is Here------------>" + learnerSubscription);

    }

    @When("^enrolled courses count api is called with parameters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to get learner enrolled courses count$")
    public void enrolled_courses_count_api_is_called_with_parameters_to_get_learner_enrolled_courses_count(String notstarted, String subscription, String inProgress) throws Throwable {

        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;

        String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
        String courseCountRequestParameters = (learnerEnrolledCoursesSteps.getCoursesCountRequestPara() + "\"notstarted\"" + "," + "\"subscription\"" + "," + "\"inProgress\"" + "]}");
        String learnerEnrolledCoursesCountEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesCountEndpoint();

        responseEnrolledCoursesCount = learnerEnrolledCoursesSteps
                .getLearnerEnrolledCoursesCount(tokenToBeSentInHeader, authorizationType,
                        courseCountRequestParameters, learnerEnrolledCoursesCountEndPoint);
        learnerNotstarted = responseEnrolledCoursesCount.path("notstarted");
        logger.info("<----------NotStarted Count Is Here------------>" + learnerNotstarted);

        learnerSubscription = responseEnrolledCoursesCount.path("subscription");
        logger.info("<----------Subscription Count Is Here------------>" + learnerSubscription);

        learnerInProgress = responseEnrolledCoursesCount.path("inProgress");
        logger.info("<----------InProgress Count Is Here------------>" + learnerInProgress);

    }

    @When("^enrolled courses count api is called with parameters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to get learner enrolled courses count$")
    public void enrolled_courses_count_api_is_called_with_parameters_to_get_learner_enrolled_courses_count(String notstarted, String subscription, String inProgress, String completed) throws Throwable {

        String tokenToBeSentInHeader = accessTokenType + " " + accessTokenFromGatewayApi;
        String authorizationType = learnerEnrolledCoursesSteps.getAuthorizationType();
        String courseCountRequestParameters = (learnerEnrolledCoursesSteps.getCoursesCountRequestPara() +"\"notstarted\"" + "," + "\"subscription\"" + "," + "\"inProgress\"" + "," + "\"completed\"" + "]}");
        String learnerEnrolledCoursesCountEndPoint = learnerEnrolledCoursesSteps.getLearnerEnrolledCoursesCountEndpoint();

        responseEnrolledCoursesCount = learnerEnrolledCoursesSteps
                .getLearnerEnrolledCoursesCount(tokenToBeSentInHeader, authorizationType,
                        courseCountRequestParameters, learnerEnrolledCoursesCountEndPoint);

        learnerNotstarted = responseEnrolledCoursesCount.path("notstarted");
        logger.info("<----------NotStarted Count Is Here------------>" + learnerNotstarted);

        learnerSubscription = responseEnrolledCoursesCount.path("subscription");
        logger.info("<----------Subscription Count Is Here------------>" + learnerSubscription);

        learnerInProgress = responseEnrolledCoursesCount.path("inProgress");
        logger.info("<----------InProgress Count Is Here------------>" + learnerInProgress);

        learnerCompleted = responseEnrolledCoursesCount.path("completed");
        logger.info("<----------Completed Count Is Here------------>" + learnerCompleted);

    }


    @Then("^api call should return learner course count for provided learner$")
    public void apiCallShouldReturnLearnerCourseCountForProvidedLearner() {

        int infoNotstarted = learnerEnrolledCoursesSteps.getLearnerCountNotstarted();
        logger.info("getInfoSubscription"+ infoNotstarted);

        int infoSubscription = learnerEnrolledCoursesSteps.getLearnerCountSubscription();
        logger.info("Subscription" + infoSubscription);

        int infoCountInProgress = learnerEnrolledCoursesSteps.getLearnerCourseCount();
        logger.info("In Progress" + infoCountInProgress);

        int infoCountComplete = learnerEnrolledCoursesSteps.getLearnerCountCompleted();
        logger.info("Completed" + infoCountComplete);

        assertEquals(SUCCESS_200, responseEnrolledCoursesCount.getStatusCode());
        assertEquals(learnerNotstarted, infoNotstarted);
        assertEquals(learnerSubscription, infoSubscription);
        assertEquals(learnerInProgress, infoCountInProgress);
        assertEquals(learnerCompleted, infoCountComplete);

    }

}
