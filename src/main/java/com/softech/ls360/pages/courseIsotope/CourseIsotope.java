package com.softech.ls360.pages.courseIsotope;

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

    @FindBy (css = ".iso-main-btn.retake")
    private WebElementFacade retakeThisCourseBtn;

    public void clickOnRetakeButton(){

        retakeThisCourseBtn.waitUntilClickable();
        logger.info("wait here");
        retakeThisCourseBtn.click();
        logger.info("clicked retake course image");
    }

    public boolean switchToCoursePlayerPage(String actualWindowHandle) {

        for(String coursePlayer : getDriver().getWindowHandles()){
            getDriver().switchTo().window(coursePlayer);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Title is here" + getDriver().getTitle());
        }
        return true;
    }



}
