package com.softech.ls360.pages.leftPanelNavigation;

import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/24/2016.
 */
public class ManagerTab extends PageObject{
    private static final Logger logger = LoggerFactory.getLogger(ManagerTab.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();

    @FindBy(css = "#wrapper > div.sidebar > div > div:nth-child(3) > button > span")
    private WebElementFacade managerClick;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(3) > div > div:nth-child(1) > a")
    private WebElementFacade manageUser;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(3) > div > div:nth-child(2) > a")
    private WebElementFacade enrollUsers;

    @FindBy(css= "#wrapper > div.sidebar > div > div:nth-child(3) > div > div:nth-child(3) > a")
    private WebElementFacade runReports;

    @FindBy (css = ".logo360")
    private WebElementFacade managerModeLogo;

    @FindBy(css = "#page-heading")
    private WebElementFacade managerUser;


    public String verifymanagerButtonIsDisplayed(){

      managerClick.waitUntilVisible();
        String managerTab = managerClick.getText();
        logger.info("manager button here" + managerTab);
        return managerTab;
    }

    public String verifyManageUser(){

        managerClick.waitUntilVisible();
        managerClick.click();
        logger.info("Clicked");
        manageUser.waitUntilVisible();
        String manageUserText = manageUser.getText();
        logger.info("Manage User is here" + manageUserText);
        return manageUserText;

    }

    public String verifyEnrollUsers(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------   verifying  Enroll Users Test         ------>");
        logger.info("<---------------------------------------------------->");

        enrollUsers.waitUntilVisible();
        String enrollUserText = enrollUsers.getText();
        logger.info("Enroll User Text is here" + enrollUserText);

        return enrollUserText;
    }

    public String verifyRunReports(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------   verifying  Run Report   Test         ------>");
        logger.info("<---------------------------------------------------->");

        runReports.waitUntilVisible();
        String runReportText = runReports.getText();
        logger.info("Run Report Text is here"+ runReportText);
        return runReportText;
    }

    public String redirectedToLmsManagerModeUserAndGroupScreen(){

        managerModeLogo.waitUntilPresent();
        managerModeLogo.waitUntilVisible();
        String managerUserHeading =  managerUser.getText();
        logger.info("Manage User text" + managerUserHeading);
        return managerUserHeading;

    }

    public void clickManagerUser(){
        managerClick.click();
        manageUser.waitUntilVisible();
        manageUser.click();
    }

    public String redirectedToLmsManagerModePlanAndEnrollScreen(){

        managerModeLogo.waitUntilPresent();
        managerModeLogo.waitUntilVisible();
        String enrollUserHeading =  managerUser.getText();
        logger.info("Enroll User text" + enrollUserHeading);
        return enrollUserHeading;

    }

    public void clickEnrollUser(){

        managerClick.click();
        enrollUsers.waitUntilVisible();
        enrollUsers.click();
    }

    public void clickRunReport(){

        managerClick.click();
        runReports.waitUntilClickable();
        runReports.click();

    }

    public String redirectedToLmsManagerModeRunSummaryScreen(){

        managerModeLogo.waitUntilPresent();
        managerModeLogo.waitUntilVisible();
        String runSummaryHeading =  managerUser.getText();
        logger.info("Summaray text" + runSummaryHeading);
        return runSummaryHeading;

    }
}

