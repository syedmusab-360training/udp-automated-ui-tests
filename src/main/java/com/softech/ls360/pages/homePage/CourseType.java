package com.softech.ls360.pages.homePage;

import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/19/2016.
 */
public class CourseType extends PageObject{

    private static final Logger logger = LoggerFactory.getLogger(LearnerTab.class);

    @FindBy (css = "#wrapper > nav")
    WebElementFacade homepageHeader;

    @FindBy(css = "#wrapper > div.main > div > div.statistics > div:nth-child(1) > div > span")
    private WebElementFacade numberOfMyCourses;

    @FindBy (css = "#wrapper > div.main > div > div.statistics > div:nth-child(2) > div > span")
    private WebElementFacade coursesInYourSubscription;

    @FindBy (css = "#wrapper > div.main > div > div.statistics > div:nth-child(3) > div > span")
    private WebElementFacade coursesYouHaveCompleted;

    @FindBy (css = "#wrapper > div.main > div > div.statistics > div:nth-child(3) > div > h4")
    private WebElementFacade completedCourseCount;

    @FindBy (css = "#wrapper > div.main > div > div.statistics > div:nth-child(2) > div > h4")
    private WebElementFacade subscriptionCourseCount;

    @FindBy (css = "#wrapper > div.main > div > div.statistics > div:nth-child(1) > div > h4")
    private WebElementFacade courseCountAllCourses;

    public String verifyNumberOfMyCourses(){
        logger.info("<---------------------------------------------------->");
        logger.info("<------Starting verify Number Of My Courses Test ---->");
        logger.info("<---------------------------------------------------->");

        numberOfMyCourses.waitUntilVisible();
        logger.info("wait here");

        String numberOfMyCoursesText = numberOfMyCourses.getText();
        logger.info("numberOfMyCourses text here" + numberOfMyCoursesText);
        return numberOfMyCoursesText;

    }

    public String coursesInYourSubscription(){
        logger.info("<---------------------------------------------------->");
        logger.info("<------     courses In Your Subscription         ---->");
        logger.info("<---------------------------------------------------->");

        coursesInYourSubscription.waitUntilVisible();
        String Subscription = coursesInYourSubscription.getText();
        logger.info("subscription courses text here" + coursesInYourSubscription);
        return Subscription;

    }

    public String coursesYouHaveCompleted(){
        logger.info("<---------------------------------------------------->");
        logger.info("<------Starting verify courses You Have Completed---->");
        logger.info("<---------------------------------------------------->");

        coursesYouHaveCompleted.waitUntilVisible();
        logger.info("wait here");

        String completedCourses = coursesYouHaveCompleted.getText();
        logger.info("completed courses text here" + coursesYouHaveCompleted);
        return completedCourses;

    }

    public void homepageDisplayedVerification(){
        homepageHeader.waitUntilPresent();
        logger.info("header is present");
    }

    public String completedCourseCount(){

        completedCourseCount.waitUntilVisible();
        String udpCompleedCourseCount = completedCourseCount.getText();
        return udpCompleedCourseCount;

    }


    public String subscriptionCourseCount (){

        subscriptionCourseCount.waitUntilVisible();
        String udpSubscriptionCourseCount = subscriptionCourseCount.getText();
        return udpSubscriptionCourseCount;
    }


    public String getCourseCountAll(){

        courseCountAllCourses.waitUntilVisible();
        String countAllCourses = courseCountAllCourses.getText();
        return  countAllCourses;
    }

}
