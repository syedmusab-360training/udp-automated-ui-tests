package com.softech.ls360.pages.homePage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by syed.musab on 10/27/2016.
 */
public class SearchBar extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(SearchBar.class);

    @FindBy(css = ".form-control")
    private WebElementFacade searchInputText;

    @FindBy(css = ".filters.All")
    private WebElementFacade searchBar;

    @FindBy(css = "#wrapper > div.main > div > div.iso-container > ul > li.filters.All > button.All")
    private WebElementFacade allButton;

    @FindBy(css = ".New")
    private WebElementFacade newButton;

    @FindBy(css = ".Started")
    private WebElementFacade startedButton;

    @FindBy(css = ".Completed")
    private WebElementFacade completedButton;

    @FindBy(css = ".Subscription")
    private WebElementFacade subscriptionButton;

    @FindBy (css = "#wrapper > div.main > div > div.iso-container > ul > li.sorting.ASC > button")
    private WebElementFacade sortBtn;

    public boolean verifyInputSearch() {
        searchBar.waitUntilVisible();
        searchInputText.waitUntilVisible();
        searchInputText.isDisplayed();
        return true;
    }

    public boolean verifySearchButtons() {
        searchBar.waitUntilVisible();
        allButton.isDisplayed();
        newButton.isDisplayed();
        startedButton.isDisplayed();
        completedButton.isDisplayed();
        subscriptionButton.isDisplayed();
        return true;
    }

    public String verifySearchButtonsAll() {

        searchBar.waitUntilVisible();
        allButton.isDisplayed();
        String allBtn = allButton.getText();
        logger.info("All button" + allBtn);
        return allBtn;
    }

    public String verifySearchButtonsNew() {
        searchBar.waitUntilVisible();
        newButton.isDisplayed();
        String newbtn = newButton.getText();
        logger.info("New button" + newbtn);
        return newbtn;
    }

    public String verifySearchButtonsStarted() {
        searchBar.waitUntilVisible();
        startedButton.isDisplayed();
        String startedBtn = startedButton.getText();
        logger.info("Started button" + startedBtn);
        return startedBtn;
    }

    public String verifySearchButtonsCompleted() {
        searchBar.waitUntilVisible();
        completedButton.isDisplayed();
        String completedBtn = completedButton.getText();
        logger.info("Completed button" + completedBtn);
        return completedBtn;
    }

    public String verifySearchButtonsSubscription() {
        searchBar.waitUntilVisible();
        subscriptionButton.isDisplayed();
        String subscriptionBtn = subscriptionButton.getText();
        logger.info("Subscription button" + subscriptionBtn);
        return subscriptionBtn;
    }

    public boolean verifySortBtn(){
        searchBar.waitUntilVisible();
        sortBtn.waitUntilClickable();
        sortBtn.isDisplayed();
        logger.info("sort button is visible");
        return true;
    }
}


