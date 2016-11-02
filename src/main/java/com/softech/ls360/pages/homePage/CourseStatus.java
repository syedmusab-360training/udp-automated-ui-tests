package com.softech.ls360.pages.homePage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/28/2016.
 */
public class CourseStatus extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(CourseStatus.class);

    @FindBy(css = "#wrapper > div.main > div > div.iso-container > div:nth-child(3) > div > div:nth-child(1) > div > div > div.iso-title")
    private WebElementFacade newStatusCourse;

    @FindBy(css = "button.New")
    private WebElementFacade newButton;

    @FindBy(css = "button.Started")
    private WebElementFacade startedButton;

    @FindBy(css = ".filters.All")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]")
    private WebElementFacade startedStatusCourses;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]")
    private WebElementFacade startedstatusCourse2;

    public String verifyNewCourses() {

        newStatusCourse.waitUntilVisible();
        newButton.waitUntilClickable();
        newButton.click();

        String newCourse = newStatusCourse.getText();
        logger.info("New Course text is here" + newCourse);
        return newCourse;

    }

    public void clickStartedBtn() {

        searchBar.waitUntilVisible();
        startedButton.waitUntilClickable();
        startedButton.click();
    }


    public String verifyStartedCourses() {

        startedStatusCourses.waitUntilVisible();
        startedButton.waitUntilClickable();
        startedButton.click();

        String startedCourse = startedStatusCourses.getText();
        logger.info("started Course text is here" + startedCourse);
        return startedCourse;

    }

}
