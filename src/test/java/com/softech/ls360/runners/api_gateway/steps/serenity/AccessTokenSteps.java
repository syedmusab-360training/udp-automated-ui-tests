package com.softech.ls360.runners.api_gateway.steps.serenity;

import com.jayway.restassured.response.Response;
import com.softech.ls360.utlis.UdpGetPropertyFromPropertiesFile;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.rest;

/**
 * Created by zuhair.mukry on 9/26/2016.
 */
public class AccessTokenSteps {
    private static final Logger logger = LoggerFactory.getLogger(AccessTokenSteps.class);
    private static final String UDP_ACCESS_TOKEN_PROPERTIES_FILE_PATH = "properties/access_token.properties";

    private UdpGetPropertyFromPropertiesFile udpAccessTokenProps = new UdpGetPropertyFromPropertiesFile();

    @Step
    public String getEndPointUrlForAccessTokenPostRequest() {
        String accessTokenEndpoints = udpAccessTokenProps.
                                        getPropertyValueFromPropertiesFile("access_token.base_url",
                                                UDP_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return accessTokenEndpoints;
    }

    @Step
    public String getBasicAuthUserNameParameterForAccessTokenRequest() {
        String basicAuthUserName = udpAccessTokenProps.
                                        getPropertyValueFromPropertiesFile("basic_auth.userName",
                                                UDP_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return basicAuthUserName;
    }

    @Step
    public String getBasicAuthPasswordParameterForAccessTokenRequest() {
        String basicAuthPassword = udpAccessTokenProps.
                                        getPropertyValueFromPropertiesFile("basic_auth.password",
                                                UDP_ACCESS_TOKEN_PROPERTIES_FILE_PATH);
        return basicAuthPassword;
    }

    @Step
    public Response requestAccessTokenFromLs360Gateway(String accessTokenEndpoint, String userName, String password) {
        logger.info("Sending Post Request to get Access Token from Gateway API");

        Response responseAccessToken = rest().given().auth().basic(userName, password).
                                    header("Accept", "application/json").
                                    when().
                                    post(accessTokenEndpoint);

        return responseAccessToken;
    }


}
