package com.softech.ls360.runners.left_panel_verification.steps.serenity;

import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.leftPanelNavigation.AuthorTab;
import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.leftPanelNavigation.ManagerTab;
import com.softech.ls360.pages.leftPanelNavigation.ResourcesTab;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class LeftNavigationSteps {

    private static final Logger logger = LoggerFactory.getLogger(LeftNavigationSteps.class);

    LearnerTab learnerTab;
    AuthorTab authorTab;
    ManagerTab managerTab;
    ResourcesTab resourcesTab;
    UdpLoginPage udpLoginPage;
    CountType countType;

    @Step
    public String verifyDashboardTitle() {

        String titleVerificationDashboard = learnerTab.verifyDashboardTitle();
        return titleVerificationDashboard;
    }

    @Step
    public String verifyLearnerTitle() {

        String titleVerificationLearner = learnerTab.verifyLearnerTitleFromLeftPanel();
        return titleVerificationLearner;
    }

    @Step
    public String verifyCourseReportTextfromLeftPanel() {

        String courseReport = authorTab.clickAuthorTab();
        return courseReport;

    }

    @Step
    public String verifyCreateManageTextFromLeftPanel() {

        String courseManagerCreate = authorTab.verifyCreateManageCourses();
        return courseManagerCreate;

    }

    @Step
    public String verifyAuthorTitle() {

        String titleVerificationAuthor = learnerTab.verifyAuthorTitleFromLeftPanel();
        return titleVerificationAuthor;
    }

    @Step
    public String verifyManagerTab() {

        String manageTab = managerTab.verifymanagerButtonIsDisplayed();
        return manageTab;
    }

    @Step
    public String verifyManageUserTextFromLeftPanel() {

        String manageUserText = managerTab.verifyManageUser();
        return manageUserText;

    }

    @Step
    public String verifyEnrollUserTextFromLeftPanel() {

        String enrollUserText = managerTab.verifyEnrollUsers();
        return enrollUserText;
    }

    @Step
    public String verifyRunReportsTextFromLeftPanel() {

        String runReportsText = managerTab.verifyRunReports();
        return runReportsText;
    }

    @Step
    public String verifyResourceText() {

        String resourceText = resourcesTab.verifyResourceText();
        return resourceText;

    }

    @Step
    public String verifyShopCourses() {

        String shopCoursesText = resourcesTab.verifyShopCourses();
        return shopCoursesText;
    }

    @Step
    public String verifyBrowserCourses() {

        String browseFreeCoursesText = resourcesTab.verifyBrowseFreeCourses();
        return browseFreeCoursesText;
    }

    @Step
    public String verifySupportForum() {

        String supportForumText = resourcesTab.verifysupportForum();
        return supportForumText;
    }

    @Step
    public String verifyManagerTitle() {

        String managerVerificationAuthor = learnerTab.verifyManagerTitleFromLeftPanel();
        return managerVerificationAuthor;
    }

    @Step
    public String verifyResourcesTitle() {

        String resourcesVerificationAuthor = learnerTab.verifyResourcesTitleFromLeftPanel();
        return resourcesVerificationAuthor;
    }

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
    public String verifyMycoursesfromLeftPanel() {

        String myCoursesLeftPanel = learnerTab.verifyMyCoursesFromLearnerMenu();
        return myCoursesLeftPanel;

    }

    @Step
    public String verifyMySubscriptionfromLeftPanel() {

        String mySubscriptionsLeftPanel = learnerTab.verifyMySubscriptionFromLearnerMenu();
        return mySubscriptionsLeftPanel;

    }

    @Step
    public String verifyTransCertFromLeftPanel() {

        String transCert = learnerTab.verifyTranscriptionCertFromLearnerMenu();
        return transCert;

    }

    @Step
    public String managerModeWindowIsDisplayed(){

        String managerMode = managerTab.redirectedToLmsManagerModeUserAndGroupScreen();
        return managerMode;

    }

    @Step
    public void clickManagerUser(){

        managerTab.clickManagerUser();
    }

    @Step
    public void clickCreateManager(){

        authorTab.clickCreateManageButton();
    }

    @Step
    public String redirectedToWlcmsAuthor(){

        String authorTitle = authorTab.redirectedToWlcmsAuthor();
        return authorTitle;

    }

    @Step
    public String redirectedToEnrollUserPage(){

        String enrollUser = managerTab.redirectedToLmsManagerModePlanAndEnrollScreen();
        logger.info("enroll user mode" + enrollUser);
        return enrollUser;

    }

    @Step
    public void clickEnrollUser(){

        managerTab.clickEnrollUser();
    }

    @Step
    public void clickRunReport(){

        managerTab.clickRunReport();

    }

    @Step
    public String redirectedToLMSRunSummaryScreen(){

        String runReport = managerTab.redirectedToLmsManagerModeRunSummaryScreen();
        logger.info("Run report text" + runReport);
        return runReport;
    }

}
