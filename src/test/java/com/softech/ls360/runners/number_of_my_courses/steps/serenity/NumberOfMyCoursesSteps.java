package com.softech.ls360.runners.number_of_my_courses.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbConnection;
import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.lms.LmsLearnerMode;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by syed.musab on 11/11/2016.
 */
public class NumberOfMyCoursesSteps {

    private static final Logger logger = LoggerFactory.getLogger(NumberOfMyCoursesSteps.class);

    LmsLearnerMode lmsLearnerMode;
    UdpLoginPage udpLoginPage;
    CountType countType;

    @Step
    public void enterUserCredentials() {

        lmsLearnerMode.setValidUsernamePassword();

    }

    @Step
    public void opens_login_page() {

        lmsLearnerMode.open();

    }

    @Step

    public void clickContinueButton() {
        lmsLearnerMode.clickContinueButton();
        logger.info("LMS Learner User Login successful");
    }

    @Step
    public void selectUserModeFromDropdown() {
        lmsLearnerMode.selectUserModeFromDropdown("Learner Mode");
    }

    @Step
    public void selectShowAvailableCoursesOption() {
        lmsLearnerMode.selectAvailableCourseOptionInDropdown();
        assertTrue(lmsLearnerMode.verifyAvailableCoursesSection());
    }


    @Step
    public void clickCourseFromSelectedCourseGroup(String lmsCourseName) {

        String actualWindowHandle;
        int numberOfWindowsOpened = 2;

        actualWindowHandle = lmsLearnerMode.getActualWindowHandle();
        assertEquals("### ASSERTION ERROR ### - Switching To Course Player Window Failed", numberOfWindowsOpened,
                lmsLearnerMode.clickCourseFormCourseGroupFromAvailableCourses());

        // lmsLearnerMode.switchToLcmsCoursePlayerPage(actualWindowHandle);
        for (String coursePlayer : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(coursePlayer);

//          assertTrue(lmsLearnerMode.verifyLcmsCoursePayerPage());
//          assertEquals(lmsCourseName, lmsLearnerMode.confirmCourseNameOnLcmsCoursePlayerPage());
            logger.info("Course Title is here" + getDriver().getTitle());

            getDriver().close();
        }
    }

    @Step
    public String udp_opens_login_page() {
        
        String actualWindowHandle = null;
        for (String lmsWindow : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(lmsWindow);
            udpLoginPage.open();

        }
        
        return actualWindowHandle;
    }


    @Step
    public void valid_userName_password() {

        lmsLearnerMode.setUdpValidUsernamePassword();
    }

    @Step
    public void click_signIn_button() {

        lmsLearnerMode.clickSignIn();

    }

    @Step
    public int getLearnerCourseCountAll() {

        DbConnection jdbcConnection = new DbConnection();
        int learnerCourseCountAll = jdbcConnection.getLearnerCountAllCoursesInfo();
        logger.info("Learner Course Count" + learnerCourseCountAll);
        return learnerCourseCountAll;
    }

    @Step
    public int courseCountAll() {
        String courseCountAll = countType.getCourseCountAll();
        return Integer.parseInt(courseCountAll);

    }


}

