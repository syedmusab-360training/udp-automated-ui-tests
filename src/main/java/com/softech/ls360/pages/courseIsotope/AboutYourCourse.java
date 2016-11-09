package com.softech.ls360.pages.courseIsotope;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/9/2016.
 */
public class AboutYourCourse extends PageObject{

    private static final Logger logger = LoggerFactory.getLogger(CourseIsotope.class);

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div[4]/div/a[2]")
    private WebElementFacade courseInfo;

    @FindBy(xpath = "//*[@id='dashboard']/div/div[3]/div[1]/div/div/div/div/div[1]/h2")
    private WebElementFacade aboutYourClass;


    public void clickOnCourseInfoButton(){

        courseInfo.waitUntilClickable();
        courseInfo.click();
    }


    public String aboutYourClassPopup(){

        aboutYourClass.waitUntilPresent();
        String aboutYourClassInfo =  aboutYourClass.getText();
        logger.info("Course Info Title text" + aboutYourClass);
        return aboutYourClassInfo;

    }

    public boolean switchToAboutYourClassPopup(){

        aboutYourClass.waitUntilPresent();
        String aboutYourClassInfo =  aboutYourClass.getText();
        logger.info("Course Info Title text" + aboutYourClassInfo);

        for(String aboutYourClass : getDriver().getWindowHandles()){
            getDriver().switchTo().window(aboutYourClass);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("about your class title is here" + getDriver().getTitle());

        }
        return true;
    }

}
