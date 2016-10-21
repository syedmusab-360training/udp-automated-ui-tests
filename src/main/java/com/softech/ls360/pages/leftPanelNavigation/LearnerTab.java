package com.softech.ls360.pages.leftPanelNavigation;

import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/19/2016.
 */
public class LearnerTab extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(LearnerTab.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();

    @FindBy(css = "#dashboard .page-heading")
    private WebElementFacade pageHeading;

    @FindBy (css = "#wrapper > div.sidebar > h4 > span")
    private WebElementFacade dashboardTitleLeftPanel;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(1) > button > span")
    private WebElementFacade learnerTitleLeftPanel;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(2) > button > span")
    private WebElementFacade authorTitleLeftPanel;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(3) > button > span")
    private WebElementFacade managerTitleLeftPanel;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(4) > button > span")
    private WebElementFacade resourcesTitleLeftPanel;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(1) > div > div:nth-child(1) > a")
    private WebElementFacade myCourseLearnerMenu;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(1) > div > div:nth-child(2) > a")
    private WebElementFacade mySubscriptionsLearnermenu;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(1) > div > div:nth-child(3) > a")
    private WebElementFacade transCertLearnerMenu;

    public String verifyPageHeading(){
        logger.info("<---------------------------------------------------->");
        logger.info("<------      Starting UDP Heading Test         ------>");
        logger.info("<---------------------------------------------------->");

        pageHeading.waitUntilVisible();
        logger.info("wait here");

        String pageTitle = pageHeading.getText();
        logger.info("Heading text page" + pageTitle);
        return pageTitle;

    }

    public String verifyDashboardTitle(){

        logger.info("<---------------------------------------------------->");
        logger.info("<-  Starting UDP Dashboard title verification Test  ->");
        logger.info("<---------------------------------------------------->");

        dashboardTitleLeftPanel.waitUntilVisible();

        String dashboardHeading = dashboardTitleLeftPanel.getText();
        logger.info("Dashboard Title is here" + dashboardHeading);

        return dashboardHeading;
    }

    public String verifyLearnerTitleFromLeftPanel(){

        learnerTitleLeftPanel.waitUntilVisible();
        String learnerTitle = learnerTitleLeftPanel.getText();
        logger.info("Learner text is here" + learnerTitle);
        return learnerTitle;

    }

    public String verifyAuthorTitleFromLeftPanel(){

        authorTitleLeftPanel.waitUntilVisible();
        String authorTitle = authorTitleLeftPanel.getText();
        logger.info("Author text is here" + authorTitle);
        return authorTitle;
    }

    public String verifyManagerTitleFromLeftPanel(){

        managerTitleLeftPanel.waitUntilVisible();
        String managerTitle = managerTitleLeftPanel.getText();
        logger.info("Manager text is here" + managerTitle);
        return managerTitle;
    }

    public String verifyResourcesTitleFromLeftPanel(){

        resourcesTitleLeftPanel.waitUntilVisible();
        String resourcesTitle = resourcesTitleLeftPanel.getText();
        logger.info("Resource text is here" + resourcesTitle);
        return resourcesTitle;
    }

    public String verifyMyCoursesFromLearnerMenu(){

        myCourseLearnerMenu.waitUntilVisible();
        String myCoursesTitle = myCourseLearnerMenu.getText();
        logger.info("Resource text is here" + myCoursesTitle);
        return myCoursesTitle;
    }


    public String verifyMySubscriptionFromLearnerMenu(){

        mySubscriptionsLearnermenu.waitUntilVisible();
        String mySubscriptionsTitle = mySubscriptionsLearnermenu.getText();
        logger.info("Subscription from left panel" + mySubscriptionsTitle);
        return mySubscriptionsTitle;
    }

    public String verifyTranscriptionCertFromLearnerMenu(){

        transCertLearnerMenu.waitUntilVisible();
        String myTransCertTitle = transCertLearnerMenu.getText();
        logger.info("trans anc cert from left panel" + myTransCertTitle);
        return myTransCertTitle;
    }
}
