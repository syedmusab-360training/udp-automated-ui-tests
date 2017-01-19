package com.softech.ls360.pages.gmailWebtest;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by syed.musab on 11/28/2016.
 */
public class GmailWebtest extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(GmailWebtest.class);

    @FindBy(id = "Email")
    private WebElementFacade userName;
    @FindBy(id = "Next")
    private WebElementFacade nextButton;

    WebDriver driver;

    public void node(){

        DesiredCapabilities cap = DesiredCapabilities.firefox();

        try {
            driver = new RemoteWebDriver(new URL("http://10.0.101.15:5555/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    public void enterUsernameValue() {

        driver.get("https://www.google.com/gmail/");
        logger.info("url opened");
        userName.type("engineermusab@gmail.com");
        logger.info("email address typed");
        nextButton.click();

    }


}

