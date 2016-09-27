package com.softech.ls360.runners.udp.steps.serenity;

import com.jayway.restassured.response.Response;
import com.softech.ls360.utlis.UdpGetPropertyFromPropertiesFile;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.rest;

/**
 * Created by zuhair.mukry on 9/27/2016.
 */
public class LearnerEnrolledCoursesSteps {
    private static final Logger logger = LoggerFactory.getLogger(LearnerEnrolledCoursesSteps.class);
    private static final String UDP_ENROLLED_COURSES_PROPERTIES_FILE = "properties/learner_enrolled_courses.properties";

    private UdpGetPropertyFromPropertiesFile udpAccessTokenProps = new UdpGetPropertyFromPropertiesFile();

    @Step
    public String getAuthorizationType() {
        String authorizationType = udpAccessTokenProps
                                    .getPropertyValueFromPropertiesFile("enrolledCourses.request.authorizationType",
                                            UDP_ENROLLED_COURSES_PROPERTIES_FILE);
        return authorizationType;
    }

    @Step
    public String getEnrolledCoursesRequestParameters() {
        //enrolledCoursesParamters =  "{\"pageSize\":\"20\",\"pageNumber\":\"1\",\"sort\":\"ASC\",\"searchText\":\"\",\"filter\":\"All\"}";
        StrBuilder enrolledCoursesParametersSb = new StrBuilder();
        enrolledCoursesParametersSb.append("{\"pageSize\":\"");
        enrolledCoursesParametersSb.append(udpAccessTokenProps
                                            .getPropertyValueFromPropertiesFile("enrolledCourses.response.pageSize",
                                            UDP_ENROLLED_COURSES_PROPERTIES_FILE));
        enrolledCoursesParametersSb.append("\",\"pageNumber\":\"");
        enrolledCoursesParametersSb.append(udpAccessTokenProps
                                            .getPropertyValueFromPropertiesFile("enrolledCourses.response.pageNumber",
                                            UDP_ENROLLED_COURSES_PROPERTIES_FILE));
        enrolledCoursesParametersSb.append("\",\"sort\":\"");
        enrolledCoursesParametersSb.append(udpAccessTokenProps
                                            .getPropertyValueFromPropertiesFile("enrolledCourses.response.sort",
                                            UDP_ENROLLED_COURSES_PROPERTIES_FILE));
        enrolledCoursesParametersSb.append("\",\"searchText\":\"");
        enrolledCoursesParametersSb.append(udpAccessTokenProps
                .getPropertyValueFromPropertiesFile("enrolledCourses.response.searchText",
                        UDP_ENROLLED_COURSES_PROPERTIES_FILE));
        enrolledCoursesParametersSb.append("\",\"filter\":\"");
        enrolledCoursesParametersSb.append(udpAccessTokenProps
                .getPropertyValueFromPropertiesFile("enrolledCourses.response.filter",
                        UDP_ENROLLED_COURSES_PROPERTIES_FILE));
        enrolledCoursesParametersSb.append("\"}");

        logger.info(enrolledCoursesParametersSb.toString());

        return enrolledCoursesParametersSb.toString();
    }

    @Step
    public String getLearnerEnrolledCoursesEndpoint() {
        String learnerEnrolledCoursesEndpoint = udpAccessTokenProps
                .getPropertyValueFromPropertiesFile("enrolledCourses.information.url",
                        UDP_ENROLLED_COURSES_PROPERTIES_FILE);
        return learnerEnrolledCoursesEndpoint;
    }

    @Step
    public Response getLearnerEnrolledCoursesInformation(String tokenToBeSentInHeader, String authorizationType,
                                                         String enrolledCoursesRequestParameters,
                                                         String learnerEnrolledCoursesInformationEndPoint) {

        Response responseEnrolledCoursesInformation = rest().
                given().
                header(authorizationType, tokenToBeSentInHeader).
                contentType("application/json").
                body(enrolledCoursesRequestParameters).
                when().
                post(learnerEnrolledCoursesInformationEndPoint);

        return responseEnrolledCoursesInformation;
    }

    @Step
    public String getCoursesCountRequestParameters() {
        String countType = "{\"countType\": [\"notstarted\", \"subscription\", " +
                "\"completed\", \"inProgress\"]}";
        return countType;
    }

    @Step
    public String getLearnerEnrolledCoursesCountEndpoint() {
        String learnerEnrolledCoursesCountEndpoint = udpAccessTokenProps
                .getPropertyValueFromPropertiesFile("enrolledCourses.count.url",
                        UDP_ENROLLED_COURSES_PROPERTIES_FILE);
        return learnerEnrolledCoursesCountEndpoint;
    }

    @Step
    public Response getLearnerEnrolledCoursesCount(String tokenToBeSentInHeader, String authorizationType,
                                                   String courseCountRequestParameters,
                                                   String learnerEnrolledCoursesCountEndPoint) {
        Response responseEnrolledCoursesCount = rest().
                given().
                header(authorizationType, tokenToBeSentInHeader).
                contentType("application/json").
                body(courseCountRequestParameters).
                when().
                post(learnerEnrolledCoursesCountEndPoint);

        return responseEnrolledCoursesCount;
    }
}
