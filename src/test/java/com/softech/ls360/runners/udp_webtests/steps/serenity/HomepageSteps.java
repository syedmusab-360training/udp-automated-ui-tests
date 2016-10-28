package com.softech.ls360.runners.udp_webtests.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbConnection;
import com.softech.ls360.jdbc_vu360_qa.DbUdpCourseStatus;
import com.softech.ls360.pages.homePage.CourseStatus;
import com.softech.ls360.pages.homePage.CourseType;
import com.softech.ls360.pages.homePage.SearchBar;
import com.softech.ls360.pages.leftPanelNavigation.AuthorTab;
import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.leftPanelNavigation.ManagerTab;
import com.softech.ls360.pages.leftPanelNavigation.ResourcesTab;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/14/2016.
 */
public class HomepageSteps {
    private static final Logger logger = LoggerFactory.getLogger(HomepageSteps.class);

    UdpLoginPage udpLoginPage;
    LearnerTab learnerTab;
    CourseType courseType;
    AuthorTab authorTab;
    ManagerTab managerTab;
    ResourcesTab resourcesTab;
    SearchBar searchBar;
    CourseStatus courseStatus;

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
    public boolean homepageIsDisplayed(){

        boolean aa = courseType.homepageDisplayedVerification();
        return aa;
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
    public String verifyTransCertFromLeftPanel(){

        String transCert = learnerTab.verifyTranscriptionCertFromLearnerMenu();
        return transCert;

    }

    @Step
    public String  verifyCourseReportTextfromLeftPanel(){

        String courseReport = authorTab.clickAuthorTab();
        return courseReport;

    }

    @Step
    public String verifyCreateManageTextFromLeftPanel(){

        String courseManagerCreate = authorTab.verifyCreateManageCourses();
        return courseManagerCreate;

    }

    @Step
    public String verifyManagerTab(){

        String manageTab = managerTab.verifymanagerButtonIsDisplayed();
        return manageTab;
    }

    @Step
    public String verifyManageUserTextFromLeftPanel(){

        String manageUserText = managerTab.verifyManageUser();
        return manageUserText;

    }

    @Step
    public String verifyEnrollUserTextFromLeftPanel(){

        String enrollUserText = managerTab.verifyEnrollUsers();
        return enrollUserText;
    }

    @Step
    public String verifyRunReportsTextFromLeftPanel(){

        String runReportsText = managerTab.verifyRunReports();
        return runReportsText;
    }

    @Step
    public String verifyResourceText(){

        String resourceText = resourcesTab.verifyResourceText();
        return resourceText;

    }

    @Step
    public String verifyShopCourses(){

        String shopCoursesText = resourcesTab.verifyShopCourses();
        return shopCoursesText;
    }

    @Step
    public String verifyBrowserCourses(){

        String browseFreeCoursesText = resourcesTab.verifyBrowseFreeCourses();
        return browseFreeCoursesText;
    }

    @Step
    public String verifySupportForum(){

        String supportForumText = resourcesTab.verifysupportForum();
        return supportForumText;
    }
    @Step
    public void openLearnerMode(){
        udpLoginPage.loginLearnerAccount();

    }

    @Step
    public String verifyResourceInLearner(){

        String resource = resourcesTab.verifyResourceTextInLearnerMode();
        return resource;

    }

    @Step
    public boolean verifySearchButton(){
        boolean searchbtn = searchBar.verifyInputSearch();
        return searchbtn;
    }

    @Step
    public boolean verifySearchBarButton(){

        boolean seachButtons = searchBar.verifySearchButtons();
        return seachButtons;
    }

    @Step
    public String verifySearchButtonAll(){

        String aa = searchBar.verifySearchButtonsAll();
        return aa;
    }

    @Step
    public String verifySearchButtonNew(){

        String newBtn = searchBar.verifySearchButtonsNew();
        return newBtn;
    }

    @Step
    public String verifySearchButtonStarted(){

        String startedBtn = searchBar.verifySearchButtonsStarted();
        return startedBtn;
    }

    @Step
    public String verifySearchButtonCompleted(){

        String completeBtn = searchBar.verifySearchButtonsCompleted();
        return completeBtn;
    }

    @Step
    public String verifySearchButtonSubscription(){

        String subscriptionBtn = searchBar.verifySearchButtonsSubscription();
        return subscriptionBtn;
    }

    @Step
    public boolean verifySortBtn(){

        boolean sortBtn = searchBar.verifySortBtn();
        return true;
    }

    @Step
    public String getLearnerNewStatusInfo(){

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        String learnerNewInfoCompleted = jdbcConnection.getLearnerNewStatusCourseInfo();
        logger.info("Learner Course New status" + learnerNewInfoCompleted);
        return learnerNewInfoCompleted;

    }

    @Step
    public String verifyNewStatusCourses(){

        String newStatusCourses = courseStatus.verifyNewCourses();
        logger.info("Course new in serenity step" + newStatusCourses);
        return newStatusCourses;
    }

    @Step
    public void clickStartedButton(){

        courseStatus.clickStartedBtn();
    }

    @Step
    public String verifyStartedStatusCourses(){

        String startedCourses = courseStatus.verifyStartedCourses();
        logger.info("Course started in serenity step" + startedCourses);
        return startedCourses;

    }

    @Step
    public String getLearnerStartedStatusInfo(){

        DbUdpCourseStatus jdbcConnection = new DbUdpCourseStatus();
        String learnerStartedInfoCompleted = jdbcConnection.getLearnerStartedStatusCourseInfo();
        logger.info("Learner Course started status" + learnerStartedInfoCompleted);
        return learnerStartedInfoCompleted;

    }

}
