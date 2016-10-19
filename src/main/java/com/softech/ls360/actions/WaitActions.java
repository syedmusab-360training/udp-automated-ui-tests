package com.softech.ls360.actions;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by syed.musab on 10/19/2016.
 */
public class WaitActions extends AbstractPageActions {

    private static final Logger logger = LoggerFactory.getLogger(WaitActions.class);

    public void waitUntilLoaded(WebElement element){
        logger.debug("WAIT - loaded");
        new WebDriverWait(getDriver() ,30)
                .until(refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public void customWaitUntilUnLoaded(By displayLocator){
        logger.info(" -- AIT UN-LOAD");
        new WebDriverWait(getDriver(),30)
                .until(displayed(ExpectedConditions.invisibilityOfElementLocated(displayLocator)));
    }


    private <T> ExpectedCondition<T> refreshed(final Function<WebDriver, T> originalFunction){
        return new ExpectedCondition<T>(){
            @Override
            public T apply(WebDriver webdriver){
                try{
                    return originalFunction.apply(webdriver);
                }catch( StaleElementReferenceException sere ){
                    throw new NoSuchElementException("Element stale.",sere);
                }
            }
        };
    }

    private <T> ExpectedCondition<T> displayed(final Function<WebDriver, T> originalFunction){
        return new ExpectedCondition<T>(){
            @Override
            public T apply(WebDriver webdriver){
                try{
                    return originalFunction.apply(webdriver);
                }catch( StaleElementReferenceException sere ){
                    throw new NoSuchElementException("Element stale.",sere);
                }
            }
        };
    }
}
