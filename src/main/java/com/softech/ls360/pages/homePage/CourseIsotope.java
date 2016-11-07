package com.softech.ls360.pages.homePage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class CourseIsotope extends PageObject{

    private static final Logger logger = LoggerFactory.getLogger(CourseIsotope.class);

    @FindBy (css = "#wrapper > div.main > div > div.iso-container > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(1) > div > div.iso-bottom-options > div > a.retake-icon")
    private WebElementFacade retakeThisCourseBtn;


    public void switchToCoursePlayerPage(String actualWindowHandle) {

        retakeThisCourseBtn.waitUntilClickable();
        logger.info("wait here");
        retakeThisCourseBtn.click();
        logger.info("clicked retake course image");

        for(String coursePlayer : getDriver().getWindowHandles()){
            getDriver().switchTo().window(coursePlayer);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Title is here" + getDriver().getTitle());

        }
    }



}
