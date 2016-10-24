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
public class ResourcesTab extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(ResourcesTab.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();

    @FindBy(css = "#wrapper > div.sidebar > div > div:nth-child(4) > button > span")
    private WebElementFacade resourcesText;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(4) > div > div:nth-child(1) > a")
    private WebElementFacade shopCourses;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(4) > div > div:nth-child(2) > a")
    private WebElementFacade browseFreeCourses;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(4) > div > div:nth-child(3) > a")
    private WebElementFacade supportForum;

    @FindBy (css = "#wrapper > div.sidebar > div > div:nth-child(1) > button > span")
    private WebElementFacade learnerTitleLeftPanel;

    public String verifyResourceText(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------   verifying resource tab Test          ------>");
        logger.info("<---------------------------------------------------->");

        resourcesText.waitUntilVisible();
        learnerTitleLeftPanel.click();
        resourcesText.click();
        String resourceTabText = resourcesText.getText();
        logger.info("resource text is here" + resourceTabText);
        return resourceTabText;

    }

    public String verifyShopCourses(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------verifying shop courses tab Test         ------>");
        logger.info("<---------------------------------------------------->");

        shopCourses.waitUntilVisible();
        String shopCoursesText = shopCourses.getText();
        logger.info("Shop Courses text" + shopCoursesText);
        return shopCoursesText;
    }


    public String verifyBrowseFreeCourses(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------verifying browseCoursesText tab Test    ------>");
        logger.info("<---------------------------------------------------->");

        shopCourses.waitUntilVisible();
        String browseCoursesText = browseFreeCourses.getText();
        logger.info("Shop Courses text" + browseCoursesText);
        return browseCoursesText;
    }

    public String verifysupportForum(){

        logger.info("<---------------------------------------------------->");
        logger.info("<------verifying supportForum tab Test         ------>");
        logger.info("<---------------------------------------------------->");

        supportForum.waitUntilVisible();
        String supportForumText = supportForum.getText();
        logger.info("Support Forum Courses text" + supportForumText);
        return supportForumText;
    }

}
