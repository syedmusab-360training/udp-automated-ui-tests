package com.softech.ls360.pages.courseIsotope;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/15/2016.
 */
public class ClassroomGearDropdown extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomGearDropdown.class);

    @FindBy(css = "div:nth-child(8) > div > div.iso-title")
    private WebElementFacade classroomCourseIsotope;

    @FindBy(css = "div:nth-child(8) > div > div.iso-bottom-options > div > div > button")
    private WebElementFacade gearIcon;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[1]/a")
    private WebElementFacade prepareForClass;

    @FindBy(className = "close")
    private WebElementFacade prepareForClassCloseBtn;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[3]/a")
    private WebElementFacade checkYourSystem;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[4]/a")
    private WebElementFacade networkAndBandwidthBtn;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[5]/a")
    private WebElementFacade lyncDemo;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[6]/a")
    private WebElementFacade labDemo;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[7]/a")
    private WebElementFacade myCourseware;

    @FindBy (xpath = "//*[@id='wrapper']/div[2]/div/div[2]/div[2]/div/div[1]/div[8]/div/div[4]/div/div/ul/li[9]/a")
    private WebElementFacade support;

    public void clickGearIcon() {

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();
    }

    public String clickPrepareForClass() {

        logger.info("clicking dropdown button");
        prepareForClass.waitUntilClickable();
        String classroomDropdown1 = prepareForClass.getText();
        prepareForClass.click();
        logger.info("clicked dropdown button");
        return classroomDropdown1;
    }

    public void SwitchWindowToClassroomPopup() {

        String classroomPopupWidowHandle = "";
        logger.info("Switching controls to video popup");
        getDriver().switchTo().window(classroomPopupWidowHandle);

        prepareForClassCloseBtn.waitUntilClickable();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prepareForClassCloseBtn.click();

    }

    public String checkYourSystemIcon() {

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("clicking dropdown button, check your system");
        checkYourSystem.waitUntilClickable();
        String classroomDropdown2 = checkYourSystem.getText();
        checkYourSystem.click();
        return classroomDropdown2;
    }

    public String networkAndBandwidthWindow(){

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("clicking dropdown button, networkAndBandwidth");
        networkAndBandwidthBtn.waitUntilClickable();
        String classroomDropdown3 = networkAndBandwidthBtn.getText();
        networkAndBandwidthBtn.click();
        return classroomDropdown3;

    }

    public String lyncDemonstrationWindow(){

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("Lync Demonstration button");
        lyncDemo.waitUntilClickable();
        String classroomDropdown4 = lyncDemo.getText();
        lyncDemo.click();
        return classroomDropdown4;
    }

    public String labDemonstrationWindow(){

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("Lab Demonstration button");
        labDemo.waitUntilClickable();
        String classroomDropdown5 = labDemo.getText();
        labDemo.click();
        return classroomDropdown5;
    }

    public String myCoursewareWindow(){

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("My Courseware Window");
        myCourseware.waitUntilClickable();
        String classroomDropdown6 = myCourseware.getText();
        myCourseware.click();
        return classroomDropdown6;
    }

    public String supportWindow(){

        classroomCourseIsotope.waitUntilPresent();
        logger.info("gear button is displayed");
        gearIcon.waitUntilClickable();
        gearIcon.click();

        logger.info("Support Window");
        support.waitUntilClickable();
        String classroomDropdown7 = support.getText();
        support.click();
        return classroomDropdown7;
    }
}

