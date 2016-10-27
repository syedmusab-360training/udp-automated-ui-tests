package com.softech.ls360.runners.udp_webtests.steps;

import com.softech.ls360.runners.udp_webtests.steps.serenity.HomepageSteps;
import com.softech.ls360.utlis.SeachButton;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by syed.musab on 10/27/2016.
 */
public class SearchbarStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(SearchbarStepDefinition.class);
    private List<SeachButton> searchBarList = new ArrayList<SeachButton>();;

    @Steps
    HomepageSteps homepageSteps;

    @Then("^Verify that on my courses page should display input field for search courses$")
    public void verify_that_on_my_courses_page_should_display_input_field_for_search_courses() {

        assertTrue(homepageSteps.verifySearchButton());
    }

    @Then("^Verify that search bar contains following button$")
    public void verify_that_search_bar_contains_following_button(DataTable dataTable) {

        searchBarList = dataTable.asList(SeachButton.class);
        logger.info("list is here" + searchBarList);
        logger.info("search bar list" + searchBarList.get(0).toString());
        assertEquals(homepageSteps.verifySearchButtonAll(), searchBarList.get(0).toString());
        assertEquals(homepageSteps.verifySearchButtonNew(), searchBarList.get(1).toString());
        assertEquals(homepageSteps.verifySearchButtonStarted(), searchBarList.get(2).toString());
        assertEquals(homepageSteps.verifySearchButtonCompleted(), searchBarList.get(3).toString());
        assertEquals(homepageSteps.verifySearchButtonSubscription(), searchBarList.get(4).toString());
        assertTrue(homepageSteps.verifySortBtn());
    }

}
