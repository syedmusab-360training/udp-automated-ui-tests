package com.softech.ls360.runners.udp_ui_webtests.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbConnection;
import com.softech.ls360.pages.leftPanelNavigation.AuthorTab;
import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.homePage.CourseType;
import net.thucydides.core.annotations.Step;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/14/2016.
 */
public class UserLoginToHomepageSteps {
    private static final Logger logger = LoggerFactory.getLogger(UserLoginToHomepageSteps.class);

    UdpLoginPage udpLoginPage;
    LearnerTab learnerTab;
    CourseType courseType;
    AuthorTab authorTab;

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
    public void invalid_userName_Password() {

        udpLoginPage.setInvalidUsernamePassword();
    }

    @Step
    public void homepageProfileDropdown() {

        udpLoginPage.verifyAndCloseHomepage();

    }

    @Step
    public void click_profile_signout_button() {

        udpLoginPage.profileDropDownBtn();

    }

    @Step
    public String get_Error_Message0(){

     String errorMessage =  udpLoginPage.displayedIncorrectMessage();
        return errorMessage;

    }

    @Step
    public String verify_page_heading(){

      String pageTitle = learnerTab.verifyPageHeading();
        return pageTitle;
    }


    @Step
    public String verifyNumberOfCoursesTitle(){

        String numberOfCourses = courseType.verifyNumberOfMyCourses();
        return numberOfCourses;
    }

    @Step
    public String verifySubscriptionTitle(){

       String subscriptionTitle = courseType.coursesInYourSubscription();
        return subscriptionTitle;
    }

    @Step
    public String verifyCompletedCourseTitle(){

        String completedCourse = courseType.coursesYouHaveCompleted();
        return completedCourse;
    }

    @Step
    public void homepageIsDisplayed(){

        courseType.homepageDisplayedVerification();
    }

    @Step
    public int getLearnerCountCompleted(){

        DbConnection jdbcConnection = new DbConnection();
        int learnerCountInfoCompleted = jdbcConnection.getLearnerCountCompletedInfo();
        logger.info("Learner Course Completed Count" + learnerCountInfoCompleted);
        return learnerCountInfoCompleted;

    }


    @Step
    public int completedCount(){

      String completedCourse = courseType.completedCourseCount();
        return Integer.parseInt(completedCourse);

    }

    @Step
    public int getLearnerSubscriptionCount(){

        DbConnection jdbcConnection = new DbConnection();
        int learnerCountInfoSubscription = jdbcConnection.getLearnerCountSubscriptionInfo();
        logger.info("Learner Course Subscription Count" + learnerCountInfoSubscription);
        return learnerCountInfoSubscription;
    }

    @Step
    public int subscriptionCount(){

        String subscriptionCount = courseType.subscriptionCourseCount();
        return Integer.parseInt(subscriptionCount);

    }


    @Step
    public int courseCountAll(){
        String courseCountAll = courseType.getCourseCountAll();
        return Integer.parseInt(courseCountAll);

    }

    @Step
    public int getLearnerCourseCountAll(){

        DbConnection jdbcConnection = new DbConnection();
        int learnerCourseCountAll = jdbcConnection.getLearnerCountAllCoursesInfo();
        logger.info("Learner Course Subscription Count" + learnerCourseCountAll);
        return learnerCourseCountAll;
    }

    @Step
    public String verifyDashboardTitle(){

        String titleVerificationDashboard = learnerTab.verifyDashboardTitle();
        return titleVerificationDashboard;
    }

    @Step
    public String verifyLearnerTitle(){

        String titleVerificationLearner = learnerTab.verifyLearnerTitleFromLeftPanel();
        return titleVerificationLearner;
    }

    @Step
    public String verifyAuthorTitle(){

        String titleVerificationAuthor = learnerTab.verifyAuthorTitleFromLeftPanel();
        return titleVerificationAuthor;
    }

    @Step
    public String verifyManagerTitle(){

        String managerVerificationAuthor = learnerTab.verifyManagerTitleFromLeftPanel();
        return managerVerificationAuthor;
    }

    @Step
    public String verifyResourcesTitle(){

        String resourcesVerificationAuthor = learnerTab.verifyResourcesTitleFromLeftPanel();
        return resourcesVerificationAuthor;
    }

    @Step
    public String verifyMycoursesfromLeftPanel(){

        String myCoursesLeftPanel = learnerTab.verifyMyCoursesFromLearnerMenu();
        return myCoursesLeftPanel;

    }

    @Step
    public String verifyMySubscriptionfromLeftPanel(){

        String mySubscriptionsLeftPanel = learnerTab.verifyMySubscriptionFromLearnerMenu();
        return mySubscriptionsLeftPanel;

    }

    @Step
    public String verifyTransCertfromLeftPanel(){

        String transCert = learnerTab.verifyTranscriptionCertFromLearnerMenu();
        return transCert;

    }

    @Step
    public String  verifyCourseReportTextfromLeftPanel(){

        String courseReport = authorTab.clickAuthorTab();
        return courseReport;

    }

}
