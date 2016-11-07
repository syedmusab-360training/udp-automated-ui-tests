package com.softech.ls360.runners.learner_mode_verification.steps.serenity;

import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.homePage.SearchBar;
import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.leftPanelNavigation.ResourcesTab;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class LearnerModeSteps {

    private static final Logger logger = LoggerFactory.getLogger(LearnerModeSteps.class);

    UdpLoginPage udpLoginPage;
    CountType countType;
    LearnerTab learnerTab;
    ResourcesTab resourcesTab;
    SearchBar searchBar;

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
    public void openLearnerMode() {
        udpLoginPage.loginLearnerAccount();

    }

    @Step
    public String verifyLearnerTitle() {

        String titleVerificationLearner = learnerTab.verifyLearnerTitleFromLeftPanel();
        return titleVerificationLearner;
    }

    @Step
    public String verifyResourceInLearner() {

        String resource = resourcesTab.verifyResourceTextInLearnerMode();
        return resource;

    }

    @Step
    public boolean verifySearchButton() {
        boolean searchbtn = searchBar.verifyInputSearch();
        return searchbtn;
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
    public String verifyAuthorTitle() {

        String titleVerificationAuthor = learnerTab.verifyAuthorTitleFromLeftPanel();
        return titleVerificationAuthor;
    }

}
