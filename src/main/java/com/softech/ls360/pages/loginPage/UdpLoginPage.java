package com.softech.ls360.pages.loginPage;

import com.softech.ls360.actions.AbstractPageActions;
import com.softech.ls360.utlis.getPropertyValueFromPropertiesFile;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/14/2016.
 */

@DefaultUrl("/LS360Dashboard/login")
public class UdpLoginPage extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(UdpLoginPage.class);
    private static final String UDP_SELENIUM_DATA_PROPERTIES_FILE = "properties/udp_selenium_data.properties";
    private getPropertyValueFromPropertiesFile udpUiDataProps = new getPropertyValueFromPropertiesFile();
    AbstractPageActions abstractPageActions = new AbstractPageActions();

    @FindBy(css = "#dashboard > div > div > div > div > div:nth-child(2) > div > input")
    private WebElementFacade userName;

    @FindBy(css = "#dashboard > div > div > div > div > div:nth-child(3) > div > input")
    private WebElementFacade password;

    @FindBy (css = ".btn.btn-primary")
    private WebElementFacade signInButton;

    @FindBy (css = ".dropdown-toggle")
    private WebElementFacade profileDropDown;

    @FindBy (css = ".dropdown-menu.dropdown-menu-right>li>a[href='/LS360Dashboard/sign-out']")
    private WebElementFacade profileSighoutbutton;

    @FindBy (css = ".control-label")
    private WebElementFacade incorrectMessage;

    @FindBy(css = ".page-heading")
    private WebElementFacade pageHeading;

    String userLearnerMode = udpUiDataProps.getPropertyValueFromPropertiesFile("udp.learnerMode.user", UDP_SELENIUM_DATA_PROPERTIES_FILE);
    String passwordLearnerMode = udpUiDataProps.getPropertyValueFromPropertiesFile("udp.learnerMode.password", UDP_SELENIUM_DATA_PROPERTIES_FILE);

    public void setValidUsernamePassword() {

        this.userName.clear();
        this.userName.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_valid_userName", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("userName Set");

        this.password.clear();
        this.password.sendKeys(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_valid_password", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Password Set");
    }

    public void setInvalidUsernamePassword(){
        this.userName.clear();
        this.userName.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_invalid_userName", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Invalid userName Set");

        this.password.clear();
        this.password.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp_invalid_password", UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Invalid Password Set");

        }

    public void clickSignIn() {
        logger.info("Clicked at SignIn");
        signInButton.click();
    }

    public void verifyAndCloseHomepage() {

        logger.info("Waiting for homePage to be displayed");
        profileDropDown.waitUntilClickable();
        profileDropDown.click();
        logger.info("DropDown button clicked");
    }

    public void profileDropDownBtn(){

        profileSighoutbutton.click();
        logger.info("Clicked on sign out from profile dropdown");
    }

    public String displayedIncorrectMessage(){
        String errorText = incorrectMessage.getText();
        return errorText;

    }

    public void loginLearnerAccount(){

     logger.info("starting learner mode test");

     this.userName.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp.learnerMode.user",
             UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("userName Set");

        this.password.type(udpUiDataProps.getPropertyValueFromPropertiesFile("udp.learnerMode.password",
                UDP_SELENIUM_DATA_PROPERTIES_FILE));
        logger.info("Password Set");

        signInButton.click();

    }

}
