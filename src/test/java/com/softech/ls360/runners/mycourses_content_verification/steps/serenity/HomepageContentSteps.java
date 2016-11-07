package com.softech.ls360.runners.mycourses_content_verification.steps.serenity;

import com.softech.ls360.jdbc_vu360_qa.DbConnection;
import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.homePage.SearchBar;
import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class HomepageContentSteps {

    private static final Logger logger = LoggerFactory.getLogger(HomepageContentSteps.class);

    CountType countType;
    LearnerTab learnerTab;
    UdpLoginPage udpLoginPage;
    SearchBar searchBar;


    @Step
    public String verifyNumberOfCoursesTitle() {

        String numberOfCourses = countType.verifyNumberOfMyCourses();
        return numberOfCourses;
    }

    @Step
    public int getLearnerCourseCountAll() {

        DbConnection jdbcConnection = new DbConnection();
        int learnerCourseCountAll = jdbcConnection.getLearnerCountAllCoursesInfo();
        logger.info("Learner Course Subscription Count" + learnerCourseCountAll);
        return learnerCourseCountAll;
    }

    @Step
    public int courseCountAll() {
        String courseCountAll = countType.getCourseCountAll();
        return Integer.parseInt(courseCountAll);

    }

    @Step
    public String verifySubscriptionTitle() {

        String subscriptionTitle = countType.coursesInYourSubscription();
        return subscriptionTitle;
    }

    @Step
    public int getLearnerSubscriptionCount() {

        DbConnection jdbcConnection = new DbConnection();
        int learnerCountInfoSubscription = jdbcConnection.getLearnerCountSubscriptionInfo();
        logger.info("Learner Course Subscription Count" + learnerCountInfoSubscription);
        return learnerCountInfoSubscription;
    }

    @Step
    public int subscriptionCount() {

        String subscriptionCount = countType.subscriptionCourseCount();
        return Integer.parseInt(subscriptionCount);

    }

    @Step
    public String verifyCompletedCourseTitle() {

        String completedCourse = countType.coursesYouHaveCompleted();
        return completedCourse;
    }

    @Step
    public int getLearnerCountCompleted() {

        DbConnection jdbcConnection = new DbConnection();
        int learnerCountInfoCompleted = jdbcConnection.getLearnerCountCompletedInfo();
        logger.info("Learner Course Completed Count" + learnerCountInfoCompleted);
        return learnerCountInfoCompleted;

    }

    @Step
    public int completedCount() {

        String completedCourse = countType.completedCourseCount();
        return Integer.parseInt(completedCourse);
    }

    @Step
    public String verify_page_heading() {

        String pageTitle = learnerTab.verifyPageHeading();
        return pageTitle;
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
    public boolean verifySearchButton() {
        boolean searchbtn = searchBar.verifyInputSearch();
        return searchbtn;
    }

    @Step
    public boolean verifySearchBarButton() {

        boolean seachButtons = searchBar.verifySearchButtons();
        return seachButtons;
    }

    @Step
    public String verifySearchButtonAll() {

        String aa = searchBar.verifySearchButtonsAll();
        return aa;
    }

    @Step
    public String verifySearchButtonNew() {

        String newBtn = searchBar.verifySearchButtonsNew();
        return newBtn;
    }

    @Step
    public String verifySearchButtonStarted() {

        String startedBtn = searchBar.verifySearchButtonsStarted();
        return startedBtn;
    }

    @Step
    public String verifySearchButtonCompleted() {

        String completeBtn = searchBar.verifySearchButtonsCompleted();
        return completeBtn;
    }

    @Step
    public String verifySearchButtonSubscription() {

        String subscriptionBtn = searchBar.verifySearchButtonsSubscription();
        return subscriptionBtn;
    }

    @Step
    public boolean verifySortBtn() {

        boolean sortBtn = searchBar.verifySortBtn();
        return true;
    }

    @Step
    public void opens_login_page() {
        udpLoginPage.open();
    }
}
