package com.softech.ls360.runners.course_status_verification.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbUdpCourseStatus;
import com.softech.ls360.pages.courseIsotope.ClassroomGearDropdown;
import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.homePage.CourseType;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class CourseStatusSteps {

    private static final Logger logger = LoggerFactory.getLogger(CourseStatusSteps.class);

    CountType countType;
    CourseType courseType;
    UdpLoginPage udpLoginPage;
    ClassroomGearDropdown classroomGearDropdown;

    @Step
    public void opens_login_page() {
        udpLoginPage.open();
    }

    @Step
    public void valid_userName_password() {

        udpLoginPage.setValidUsernamePassword();
    }

    @Step
    public void click_signIn_button() {

        udpLoginPage.clickSignIn();
    }

    @Step
    public boolean homepageIsDisplayed() {

        boolean aa = countType.homepageDisplayedVerification();
        return aa;
    }

    @Step
    public void clickStartedButton() {

        courseType.clickStartedBtn();
    }


    @Step
    public void clickCompletedButton() {

        courseType.clickCompletedBtn();
    }

    @Step
    public String getLearnerNewStatusInfo() {

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        String learnerNewInfoCompleted = jdbcConnection.getLearnerNewStatusCourseInfo();
        logger.info("Learner Course New status" + learnerNewInfoCompleted);
        return learnerNewInfoCompleted;

    }


    @Step
    public String verifyNewStatusCourses() {

        String newStatusCourses = courseType.verifyNewCourses();
        logger.info("Course new in serenity steps" + newStatusCourses);
        return newStatusCourses;


    }

    @Step
    public String getLearnerStartedStatusInfo() {

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        String learnerStartedInfoCompleted = jdbcConnection.getLearnerStartedStatusCourseInfo();
        logger.info("Learner Course started status" + learnerStartedInfoCompleted);
        return learnerStartedInfoCompleted;

    }

    @Step
    public String getLearnerCompletedStatusInfo() {

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        String learnerCompletedInfoCompleted = jdbcConnection.getLearnerCompletedStatusCourseInfo();
        logger.info("Learner Course Completed status" + learnerCompletedInfoCompleted);
        return learnerCompletedInfoCompleted;

    }

    @Step
    public String verifyCompletedTypeCourses() {

        String completedCourse = courseType.verifyCompletedCourses();
        logger.info("Learner Course Completed Type" + completedCourse);
        return completedCourse;

    }

    @Step
    public String verifyStartedStatusCourses() {

        String startedCourses = courseType.verifyStartedCourses();
        logger.info("Course started in serenity steps" + startedCourses);
        return startedCourses;

    }

}
