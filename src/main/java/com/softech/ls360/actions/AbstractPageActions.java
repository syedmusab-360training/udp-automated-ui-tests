package com.softech.ls360.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.refreshed;

/**
 * Created by syed.musab on 10/18/2016.
 */
public class AbstractPageActions {
    private static final Logger logger = LoggerFactory.getLogger(AbstractPageActions.class);

    public void waitUntilLoaded(WebElementFacade profileDropDown) {

        logger.debug("WAIT - loaded");
        new WebDriverWait(getDriver() ,30)
                .until(refreshed(ExpectedConditions.visibilityOf(profileDropDown)));
    }
}
