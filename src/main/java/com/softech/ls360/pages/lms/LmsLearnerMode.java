package com.softech.ls360.pages.lms;

import com.softech.ls360.actions.SwitchControlToOpenedPage;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by syed.musab on 11/11/2016.
 */
@DefaultUrl("https://qa-lms.360training.com/lms/login.do")
public class LmsLearnerMode extends PageObject {

    private SwitchControlToOpenedPage switchControlToOpenedPage;
    private static final Logger logger = LoggerFactory.getLogger(LmsLearnerMode.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();

    @FindBy(id = "j_username")
    private WebElementFacade lmsUserName;

    @FindBy(id = "j_password")
    private WebElementFacade lmsUserPassword;

    @FindBy(css = ".btn_normal")
    private WebElementFacade signInButton;

    @FindBy(css = ".btn_normal")
    private WebElementFacade modeDropDown;

    @FindBy(css = "#content .btn_normal")
    private List<WebElementFacade> homePageButtons;

    @FindBy(id = "drpMode")
    private WebElementFacade userModeDropdown;

    @FindBy(id = "show")
    private WebElementFacade showCoursesDropdown;

    @FindBy (css = "#learner-my-courses")
    private WebElementFacade myCourses;

    @FindBy(id = "coursegroup-courses")
    private WebElementFacade courseGroupCoursesSection;

    @FindBy(css = "div.selection-message")
    private WebElementFacade selectionMessageText;

    @FindBy(id = "course-title-0")
    private WebElementFacade firstCourseInList;

    @FindBy(id = "coursetitle")
    private WebElementFacade leftMenuCourseTitle;

    @FindBy(id = "group-0-14712")
    private WebElementFacade courseGroup;

    @FindBy(css = "#coursetitle")
    private WebElementFacade coursePlayerTitle;

    @FindBy(css = "#dashboard > div > div > div > div > div:nth-child(2) > div > input")
    private WebElementFacade udpUserName;

    @FindBy(css = "#dashboard > div > div > div > div > div:nth-child(3) > div > input")
    private WebElementFacade udpPassword;

    @FindBy (css = ".btn.btn-primary")
    private WebElementFacade udpSignInButton;

    public void lmsGetCurrentUrl(){

        getDriver().get(udpUiDataProps.getPropertyValueFromPropertiesFile("lms_qa_url", UDP_SELENIUM_DATA_PROPERTIES_FILE));

    }

    public void setUdpValidUsernamePassword() {

        this.udpUserName.clear();
        this.udpUserName.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_valid_userName", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("userName provided");

        this.udpPassword.clear();
        this.udpPassword.sendKeys(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_valid_password", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Password provided");
    }


    public void setValidUsernamePassword() {

        getDriver().get("https://qa-lms.360training.com/lms/login.do");
        lmsUserName.waitUntilVisible();
        this.lmsUserName.clear();
        this.lmsUserName.type(udpUiDataProps.getPropertyValueFromPropertiesFile("lms_qa_userName", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("userName provided");

        lmsUserPassword.waitUntilVisible();
        this.lmsUserPassword.clear();
        this.lmsUserPassword.type(udpUiDataProps.getPropertyValueFromPropertiesFile("lms_qa_password", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Password provided");

        signInButton.waitUntilClickable();
        signInButton.click();
    }


    public void clickContinueButton() {
        for (WebElement e : homePageButtons) {
            if (e.getText().equalsIgnoreCase("Continue")) {
                logger.info("Clicking Button: " + e.getText());
                e.click();
                break;
            }
        }
    }

    public void selectUserModeFromDropdown(String userModeLabel) {
        Select modeDropdown = new Select(userModeDropdown);
        modeDropdown.selectByVisibleText(userModeLabel);
    }

    public boolean verifyAvailableCoursesSection() {
        courseGroupCoursesSection.waitUntilVisible();
        selectionMessageText.waitUntilVisible();
        logger.info("Selected Available Courses from dropdown - Displaying Message: \""
                + selectionMessageText.getText() + "\"");

        return selectionMessageText.isCurrentlyVisible();
    }

    public void selectAvailableCourseOptionInDropdown() {
        myCourses.waitUntilClickable();
        myCourses.click();
        showCoursesDropdown.waitUntilVisible();
        Select coursesDropdown = new Select(showCoursesDropdown);
        if (coursesDropdown.getFirstSelectedOption().getText().equalsIgnoreCase("Available Courses")) {
            logger.info("Available Courses Option already selected");
        } else {
            coursesDropdown.selectByValue("coursecatalog");
            logger.info("Selected Available Courses Option from dropdown");
        }
    }

    public int clickCourseFormCourseGroupFromAvailableCourses() {

        courseGroup.waitUntilVisible();
        courseGroup.click();
        logger.info("LMS My Course Page - Clicking Course: " + firstCourseInList.getText());
        firstCourseInList.click();
        logger.info("Clicked Course - Opening New Window, where course will be launched");

        // some random delay
        for (int i = 0; i < 5; i++) {
            waitABit(25000);
            if (getDriver().getWindowHandles().size() == 2) {
                break;
            }

        }

        return getDriver().getWindowHandles().size();

    }

    public String getActualWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public void switchToLcmsCoursePlayerPage(String actualWindowHandle) {
        switchControlToOpenedPage.switchToOpenedWindow(actualWindowHandle);
    }


    public boolean verifyLcmsCoursePayerPage() {
        try {
            setImplicitTimeout(30, TimeUnit.SECONDS);
            waitABit(3000);
            withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(leftMenuCourseTitle));
            logger.info("Verifying Course Player Window");
        } catch (Exception e) {
            logger.info("### Timeout after waiting for Left Menu Course Title ###");
            e.printStackTrace();
        } finally {
            logger.info("Resetting Implicit Timeout to default value");
            resetImplicitTimeout();
            getDriver().quit();
        }

        return leftMenuCourseTitle.isDisplayed();
    }

    public String confirmCourseNameOnLcmsCoursePlayerPage() {

        logger.info("Switched Successfully to LCMS Course Player Page");
        leftMenuCourseTitle.waitUntilVisible();
        String courseName = leftMenuCourseTitle.getText();
        logger.info("Displaying  Course Title: " + courseName);
        return courseName;
    }



    public boolean switchToCoursePlayerPopup(){

        coursePlayerTitle.waitUntilPresent();
        String coursePlayerinfo =  coursePlayerTitle.getText();
        logger.info("Course player Title text" + coursePlayerinfo);

        for(String coursePlayer : getDriver().getWindowHandles()){
            getDriver().switchTo().window(coursePlayer);

            logger.info("about player title is here" + getDriver().getTitle());
            getDriver().switchTo();
        }
        return true;
    }


    public void clickSignIn(){

        udpSignInButton.waitUntilClickable();
        udpSignInButton.click();
    }
}
