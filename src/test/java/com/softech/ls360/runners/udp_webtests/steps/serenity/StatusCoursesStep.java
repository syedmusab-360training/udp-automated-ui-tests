package com.softech.ls360.runners.udp_webtests.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbUdpCourseStatus;
import com.softech.ls360.pages.homePage.CourseStatus;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/28/2016.
 */
public class StatusCoursesStep {

    private static final Logger logger = LoggerFactory.getLogger(StatusCoursesStep.class);

    CourseStatus courseStatus;
    UdpLoginPage udpLoginPage;

    @Step
    public void opens_login_page() {
        udpLoginPage.open();
    }

    @Step
    public void clickStartedButton(){

        courseStatus.clickStartedBtn();
    }

    @Step
    public String verifyStartedStatusCourses(){

        String startedCourses = courseStatus.verifyStartedCourses();
        return startedCourses;

    }

    @Step
    public Object getLearnerStartedStatusInfo(){

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        Object learnerStartedInfoCompleted = jdbcConnection.getLearnerStartedStatusCourseInfo();
        logger.info("Learner Course New status" + learnerStartedInfoCompleted);
        return learnerStartedInfoCompleted;

    }
}

