package com.softech.ls360.pages.courseIsotope;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/10/2016.
 */
public class TimeSpent extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(TimeSpent.class);

    @FindBy(css = "div:nth-child(1) > div > div:nth-child(4) > div.iso-time-take")
    private WebElementFacade courseTimeSpent;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]")
    private WebElementFacade startedStatusCourses;

    @FindBy(css = "button.Started")
    private WebElementFacade startedButton;


    public boolean timeSpentDisplayed(){

        startedStatusCourses.waitUntilVisible();
        startedButton.waitUntilClickable();
        startedButton.click();

        courseTimeSpent.waitUntilVisible();
        boolean timeSpent = Boolean.parseBoolean(courseTimeSpent.getText());
        logger.info("Course Time Spent button is displayed for online course" + timeSpent + courseTimeSpent.getText());
        return true;

    }



}
