package com.softech.ls360.pages.leftPanelNavigation;

import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/21/2016.
 */
public class AuthorTab extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(LearnerTab.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();


    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(2) > button > span")
    private WebElementFacade authorClick;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(2) > div > div:nth-child(1) > a")
    private WebElementFacade courseReport;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(2) > div > div:nth-child(2) > a")
    private WebElementFacade createManage;

    public String clickAuthorTab(){

        logger.info("<---------------------------------------------------->");
        logger.info("<-  Starting UDP Dashboard title verification Test  ->");
        logger.info("<---------------------------------------------------->");

        authorClick.waitUntilVisible();
        authorClick.click();

        logger.info("Clicked");

        courseReport.waitUntilVisible();

        String courseReportText = courseReport.getText();
        logger.info("Course report text is here"+ courseReportText);
        return courseReportText;
    }


}

