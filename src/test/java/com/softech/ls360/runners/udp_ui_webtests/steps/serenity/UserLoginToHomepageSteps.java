package com.softech.ls360.runners.udp_ui_webtests.steps.serenity;

import com.softech.ls360.pages.LoginPage.MyCoursesVerification;
import net.thucydides.core.annotations.Step;
import com.softech.ls360.pages.LoginPage.UdpLoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/14/2016.
 */
public class UserLoginToHomepageSteps {
    private static final Logger logger = LoggerFactory.getLogger(UserLoginToHomepageSteps.class);

    UdpLoginPage udpLoginPage;
    MyCoursesVerification myCoursesVerification;

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
    public void invalid_userName_Password() {

        udpLoginPage.setInvalidUsernamePassword();
    }

    @Step
    public void homepageIsDisplayed() {

        udpLoginPage.verifyAndCloseHomepage();

    }

    @Step
    public void click_profile_signout_button() {

        udpLoginPage.profileDropDownBtn();

    }

    @Step
    public String get_Error_Message0(){

     String errorMessage =  udpLoginPage.displayedIncorrectMessage();
        return errorMessage;

    }

    @Step
    public String verify_page_heading(){

      String pageTitle = myCoursesVerification.verifyPageHeading();
        return pageTitle;
    }


}
