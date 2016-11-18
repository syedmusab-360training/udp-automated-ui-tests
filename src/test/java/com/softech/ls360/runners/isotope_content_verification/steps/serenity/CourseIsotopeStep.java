package com.softech.ls360.runners.isotope_content_verification.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbCourseTimeSpent;
import com.softech.ls360.pages.courseIsotope.AboutYourCourse;
import com.softech.ls360.pages.courseIsotope.CourseIsotope;
import com.softech.ls360.pages.courseIsotope.TimeSpent;
import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class CourseIsotopeStep {

    private static final Logger logger = LoggerFactory.getLogger(CourseIsotopeStep.class);

    CourseIsotope courseIsotope;
    UdpLoginPage udpLoginPage;
    CountType countType;
    AboutYourCourse aboutYourCourse;
    TimeSpent timeSpent;


    @Step
    public boolean clickRekateCourseBtn(String actualWindowHandle) {

        boolean coursePlayer = courseIsotope.switchToCoursePlayerPage(actualWindowHandle);
        return coursePlayer;

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
    public void opens_login_page() {
        udpLoginPage.open();
    }

    @Step
    public void clickPlayButton() {

        courseIsotope.clickOnRetakeButton();

    }


    @Step
    public void clickCourseInfo() {

        aboutYourCourse.clickOnCourseInfoButton();

    }


    @Step
    public boolean aboutYourClassPopup() {

        boolean aa = aboutYourCourse.switchToAboutYourClassPopup();
        return aa;
    }

    @Step
    public int getTimeSpentInfo() {

        DbCourseTimeSpent jdbcConnection = new DbCourseTimeSpent();
        int learnerCourseTimeSpentInfo = jdbcConnection.getCourseTimeSpentInfo();
        logger.info("Learner Course Time Spent database" + learnerCourseTimeSpentInfo);
        return learnerCourseTimeSpentInfo;

    }


    @Step
    public boolean courseTimeSpentInfoIsDisplayed() {

        boolean aa = timeSpent.timeSpentDisplayed();
        logger.info("Udp course time spent" + aa);
        return aa;

    }
}
