package com.softech.ls360.runners.login_verification.steps.Serenity;

import com.softech.ls360.pages.leftPanelNavigation.LearnerTab;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class LoginVerificationSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginVerificationSteps.class);

    UdpLoginPage udpLoginPage;
    LearnerTab learnerTab;

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
    public void homepageProfileDropdown() {

        udpLoginPage.verifyAndCloseHomepage();

    }

    @Step
    public void click_profile_signout_button() {

        udpLoginPage.profileDropDownBtn();

    }

    @Step
    public String get_Error_Message0() {

        String errorMessage = udpLoginPage.displayedIncorrectMessage();
        return errorMessage;

    }


}
