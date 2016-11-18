package com.softech.ls360.runners.classroom_gear_dropdown.steps.serenity;

import com.softech.ls360.pages.courseIsotope.ClassroomGearDropdown;
import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/16/2016.
 */
public class ClassroomGearSteps {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomGearSteps.class);

    ClassroomGearDropdown classroomGearDropdown;
    UdpLoginPage udpLoginPage;
    CountType countType;

    @Step
    public void clickGearDropdown(){

        classroomGearDropdown.clickGearIcon();
        logger.info("clicked dropdown");
    }

    @Step
    public void opens_login_page() {
        udpLoginPage.open();
    }

    @Step
    public void valid_userName_password() {

        udpLoginPage.setValidUsernamePassword();
    }

    @Step
    public void click_signIn_button() {

        udpLoginPage.clickSignIn();
    }

    @Step
    public boolean homepageIsDisplayed() {

        boolean homepageDisplayed = countType.homepageDisplayedVerification();
        return homepageDisplayed;
    }


    @Step
    public String clickPrepareForClassroom(){

        String clickPrepareForClasslink = classroomGearDropdown.clickPrepareForClass();
        return clickPrepareForClasslink;

    }

    @Step
    public boolean switchToMoviePopupClassroom(){

        classroomGearDropdown.SwitchWindowToClassroomPopup();
        return true;
    }

    @Step
    public String clickCheckYourSystem(){

        String clicking = classroomGearDropdown.checkYourSystemIcon();
        return clicking;
    }

    @Step
    public String networkAndBandwidth(){

        String networkBandwidth = classroomGearDropdown.networkAndBandwidthWindow();
        return networkBandwidth;
    }

    @Step
    public String lyncDemonstration(){

        String lyncDemo = classroomGearDropdown.lyncDemonstrationWindow();
        return lyncDemo;
    }

    @Step
    public String labDemonstration(){

        String labDemo = classroomGearDropdown.labDemonstrationWindow();
        return labDemo;
    }

    @Step
    public String myCoursewarWindow(){

        String courseWare = classroomGearDropdown.myCoursewareWindow();
        return courseWare;
    }

    @Step
    public String supportWindow(){

        String support = classroomGearDropdown.supportWindow();
        return support;

    }
}


