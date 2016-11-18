package com.softech.ls360.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by syed.musab on 11/11/2016.
 */
public class SwitchControlToOpenedPage extends AbstractPageActions {

    private static final Logger logger = LoggerFactory.getLogger(SwitchControlToOpenedPage.class);

    public void switchToOpenedWindow(String actualWindowHandle) {
        Set<String> allLcmsWindows = getDriver().getWindowHandles();
        String lcmsCoursePlayerWindowHandle="";

        for(String aHandle : allLcmsWindows){
            if( ! (actualWindowHandle.contentEquals(aHandle)) ){
                lcmsCoursePlayerWindowHandle = aHandle;
                logger.info("LCMS Course Player Window Handle" + lcmsCoursePlayerWindowHandle);
                break;
            }
        }
        getDriver().switchTo().window(lcmsCoursePlayerWindowHandle);
        logger.info("Switching controls to Opened Window");
    }
}
