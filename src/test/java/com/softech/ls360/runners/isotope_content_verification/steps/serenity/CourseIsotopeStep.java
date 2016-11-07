package com.softech.ls360.runners.isotope_content_verification.steps.serenity;

import com.softech.ls360.pages.homePage.CountType;
import com.softech.ls360.pages.homePage.CourseIsotope;
import com.softech.ls360.pages.loginPage.UdpLoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 11/3/2016.
 */
public class CourseIsotopeStep {

    private static final Logger logger = LoggerFactory.getLogger(CourseIsotopeStep.class);

    CourseIsotope courseIsotope;
    UdpLoginPage udpLoginPage;
    CountType countType;

    @Step
    public void clickRekateCourseBtn(String actualWindowHandle) {

        courseIsotope.switchToCoursePlayerPage(actualWindowHandle);

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

        boolean aa = countType.homepageDisplayedVerification();
        return aa;
    }

    @Step
    public void opens_login_page() {
        udpLoginPage.open();
    }


}
