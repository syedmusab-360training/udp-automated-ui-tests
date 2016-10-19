package com.softech.ls360.pages.LoginPage;

import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/19/2016.
 */
public class MyCoursesVerification extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(UdpLoginPage.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();

    @FindBy(css = "#dashboard .page-heading")
    private WebElementFacade pageHeading;

    @FindBy(css = "")
    private WebElementFacade bgLoader;

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
}
